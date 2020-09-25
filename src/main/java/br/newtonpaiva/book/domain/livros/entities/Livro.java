package br.newtonpaiva.book.domain.livros.entities;

import java.time.LocalDateTime;

import br.newtonpaiva.book.api.livros.request.LivroRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

	public Livro(LivroRequest request) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.editora = livro.getEditora();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.anoDeModelo = livro.getAnoDeModelo();
		this.status = livro.getStatus();
	}
		
	private String id;
	
	private String titulo;
	
	private String autor;
	
	private String editora;
	
	private String dataDePublicacao;
	
	private int status;

}
