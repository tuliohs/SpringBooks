package br.newtonpaiva.book.api.livros.request;

import static br.newtonpaiva.book.common.exception.Messages.MSG_FIELD_CANNOT_BE_BLANK;
import static br.newtonpaiva.book.common.exception.Messages.MSG_FIELD_CANNOT_BE_NULL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroRequest {

	private String id;

	@NotBlank(message = MSG_FIELD_CANNOT_BE_BLANK)
	private String marca;

	@NotBlank(message = MSG_FIELD_CANNOT_BE_BLANK)
	private String modelo;

	@NotNull(message = MSG_FIELD_CANNOT_BE_NULL)
	private Integer anoDeFabricacao;

	@NotNull(message = MSG_FIELD_CANNOT_BE_NULL)
	private Integer anoDeModelo;

	private Integer km;

}
