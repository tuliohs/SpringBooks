package br.newtonpaiva.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.newtonpaiva.book.domain.livros.entity.Livro;
import br.newtonpaiva.book.domain.livros.repo.LivroRepo;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {

	@Autowired
	private LivroRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// limpar base
		repo.deleteAll();

		// listando os automoveis
		for (Livro a : repo.findAll()) {
			System.out.println(a);
		}
	}
}
/*
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/book-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
*/