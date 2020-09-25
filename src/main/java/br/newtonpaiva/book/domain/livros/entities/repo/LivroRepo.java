package br.newtonpaiva.book.domain.livros.entities.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.newtonpaiva.book.domain.livros.entities.Livro;

public interface LivroRepo extends MongoRepository<Livro, String> {

}
