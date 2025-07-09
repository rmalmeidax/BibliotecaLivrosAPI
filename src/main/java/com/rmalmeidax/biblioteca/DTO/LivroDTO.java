package com.rmalmeidax.biblioteca.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

	private Long id;
	@NotBlank(message = "Preencha o campo nome.")
	private String nome;

}
