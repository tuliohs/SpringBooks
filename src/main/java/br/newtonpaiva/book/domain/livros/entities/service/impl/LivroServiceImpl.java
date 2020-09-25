package br.newtonpaiva.ead.aaw.lab.domain.livros.service.impl;

import static br.newtonpaiva.ead.aaw.lab.common.exception.Messages.MSG_Livro_COM_ID_NÃO_ENCONTRADO;
import static java.lang.String.format;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.newtonpaiva.book.api.livros.request.LivroRequest;
import br.newtonpaiva.book.common.exception.Messages;
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
		
		Livro a = new Livro(request);
		
		LocalDateTime now = LocalDateTime.now();
		a.setCreated(now);
		a.setModified(now);
		a.setId(UUID.randomUUID().toString());
		
		repo.save(a);
		
		return a;
	}

	@Override
	public Livro update(String id, LivroRequest request) {

		var a = getById(id);
		
		a.setAnoDeFabricacao(request.getAnoDeFabricacao());
		a.setAnoDeModelo(request.getAnoDeModelo());
		a.setKm(request.getKm());
		a.setMarca(request.getMarca());
		a.setModelo(request.getModelo());
		
		a.setModified(LocalDateTime.now());
		
		repo.save(a);
		
		return a;
	}

	@Override
	public Livro getById(String id) {
		
		Optional<Livro> a = repo.findById(id);
		
		if (a.isEmpty()) {
			throw new NotFoundException(format(MSG_Livro_COM_ID_NÃO_ENCONTRADO, id));
		}
		
		return a.get();
	}

	@Override
	public List<Livro> getAllByMarca(String marca) {
		return repo.findByMarca(marca);
	}

	@Override
	public List<Livro> getAllByModelo(String modelo) {
		return repo.findByModelo(modelo);
	}

	@Override
	public List<Livro> getAll() {
		return repo.findAll();
	}

}
