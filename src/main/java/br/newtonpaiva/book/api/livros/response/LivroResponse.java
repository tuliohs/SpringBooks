package br.newtonpaiva.book.api.livros.response;

import br.newtonpaiva.si.aaw.tcc.ref.domain.automoveis.entities.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponse {
	
	public LivroResponse(Livro livro) {
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
