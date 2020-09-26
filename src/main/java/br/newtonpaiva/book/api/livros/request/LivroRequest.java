package br.newtonpaiva.book.api.livros.request;

import static br.newtonpaiva.book.common.exception.Messages.MSG_FIELD_CANNOT_BE_BLANK;
//import static br.newtonpaiva.book.common.exception.Messages.MSG_FIELD_CANNOT_BE_NULL;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*ApiRequest is similar with Model but includ annotations*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequest {

	private String id;

	@NotBlank(message = MSG_FIELD_CANNOT_BE_BLANK)
	private String titulo;

	@NotBlank(message = MSG_FIELD_CANNOT_BE_BLANK)
	private String autor;

	@NotBlank(message = MSG_FIELD_CANNOT_BE_BLANK)
	private String editora;

	private String dataDePublicacao;

	private int status;

}
