package br.newtonpaiva.book.domain.livros.entity;

//import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import br.newtonpaiva.book.api.livros.request.LivroRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
/* Livro is very similiar with model */
public class Livro {

    public Livro(LivroRequest request) {
        this.id = request.getId();
        this.titulo = request.getTitulo();
        this.autor = request.getAutor();
        this.editora = request.getEditora();
        this.dataDePublicacao = request.getDataDePublicacao();
        this.status = request.getStatus();
    }

    @Id
    private String id;

    private String titulo;

    private String autor;

    private String editora;

    private String dataDePublicacao;

    private int status;
}
