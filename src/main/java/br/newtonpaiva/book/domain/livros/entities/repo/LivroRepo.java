package br.newtonpaiva.book.domain.livros.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.newtonpaiva.book.domain.livros.entity.Livro;

public interface LivroRepo extends MongoRepository<Livro, String> {


}
