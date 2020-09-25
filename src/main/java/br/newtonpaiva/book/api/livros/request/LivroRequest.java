package br.newtonpaiva.book.api.livros.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequest {
	
	private String id;
	
	private String titulo;
	
	private String autor;
	
	private String editora;
	
	private String dataDePublicacao;
	
	private int status;

}
