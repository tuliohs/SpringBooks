package br.newtonpaiva.book.application.livros.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.book.api.livros.request.LivroRequest;
import br.newtonpaiva.book.api.livros.resource.LivroResource;
import br.newtonpaiva.book.api.livros.response.LivroResponse;
import br.newtonpaiva.book.domain.livros.entity.Livro;

@RestController
public class LivrosController implements LivroResource {

	private Map<UUID, Livro> livros = new HashMap<UUID, Livro>();

	@Override
	public ResponseEntity<List<LivroResponse>> getAll() {

		var lista = new ArrayList<LivroResponse>();

		livros.keySet().forEach(key -> {
			lista.add(new LivroResponse(livros.get(key)));
		});

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@Override
	public ResponseEntity<LivroResponse> getById(Optional<String> id) {

		var livro = livros.get(UUID.fromString(id.get()));

		if (livro == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(new LivroResponse(livro));
	}

	@Override
	public ResponseEntity<LivroResponse> create(Optional<LivroRequest> request) {

		if (request.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		if (request.get().getId() == null || request.get().getId().trim().isEmpty()) {
			request.get().setId(UUID.randomUUID().toString());
		}

		Livro value = new Livro(request.get());
		livros.put(UUID.fromString(request.get().getId()), value);

		return ResponseEntity.status(HttpStatus.CREATED).body(new LivroResponse(value));
	}

	@Override
	public ResponseEntity<LivroResponse> update(Optional<UUID> id, Optional<LivroRequest> request) {
		if (request.isEmpty() || request.get().getId() == null || request.get().getId().trim().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

		var livro = livros.get(UUID.fromString(request.get().getId()));

		if (livro == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		Livro value = new Livro(request.get());
		livros.put(UUID.fromString(request.get().getId()), value);

		return ResponseEntity.status(HttpStatus.OK).body(new LivroResponse(value));
	}

	@Override
	public ResponseEntity<UUID> deleteById(Optional<String> id) {

		UUID uuid = UUID.fromString(id.get());
		var livro = livros.get(uuid);

		if (livro == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		livros.remove(uuid);

		return new ResponseEntity<UUID>(HttpStatus.NO_CONTENT);
	}

}
