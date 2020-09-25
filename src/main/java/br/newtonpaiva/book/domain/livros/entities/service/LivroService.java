package br.newtonpaiva.book.domain.livros.entities.service;

import java.util.List;

import br.newtonpaiva.book.api.livros.request.LivroRequest;
import br.newtonpaiva.book.domain.livros.entities.Livro;

public interface LivroService {

	Livro create(LivroRequest request);

	Livro update(String id, LivroRequest request);

	Livro getById(String id);

	void deleteById(String id);

	List<Livro> getAll();

}
