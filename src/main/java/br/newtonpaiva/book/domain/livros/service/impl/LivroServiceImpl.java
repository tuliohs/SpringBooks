package br.newtonpaiva.book.domain.livros.service.impl;

import static br.newtonpaiva.book.common.exception.Messages.MSG_LIVRO_COM_ID_NÃO_ENCONTRADO;
import static java.lang.String.format;

//import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.newtonpaiva.book.api.livros.request.LivroRequest;
//import br.newtonpaiva.book.common.exception.Messages;
import br.newtonpaiva.book.common.exception.NotFoundException;
import br.newtonpaiva.book.domain.livros.entity.Livro;
import br.newtonpaiva.book.domain.livros.repo.LivroRepo;
import br.newtonpaiva.book.domain.livros.service.LivroService;

@Component
public class LivroServiceImpl implements LivroService {

	@Autowired
	private LivroRepo repo;

	@Override
	public void deleteById(String id) {

		getById(id);

		repo.deleteById(id);
	}

	@Override
	public Livro create(LivroRequest request) {

		// create new Onj with received params
		Livro a = new Livro(request);

		// change athers field
		a.setId(UUID.randomUUID().toString());
		/*
		 * Implemment create date LocalDateTime now = LocalDateTime.now(); a.(now);
		 * a.setModified(now);
		 */

		repo.save(a);
		return a;
	}

	@Override
	public Livro update(String id, LivroRequest request) {

		var a = getById(id);

		a.setAutor(request.getAutor());
		a.setEditora(request.getEditora());
		a.setTitulo(request.getTitulo());
		a.setDataDePublicacao(request.getDataDePublicacao());
		a.setStatus(request.getStatus());

		repo.save(a);
		return a;
	}

	@Override
	public Livro getById(String id) {

		Optional<Livro> a = repo.findById(id);

		if (a.isEmpty()) {
			throw new NotFoundException(format(MSG_LIVRO_COM_ID_NÃO_ENCONTRADO, id));
		}

		return a.get();
	}

	@Override
	public List<Livro> getAll() {
		return repo.findAll();
	}

}
