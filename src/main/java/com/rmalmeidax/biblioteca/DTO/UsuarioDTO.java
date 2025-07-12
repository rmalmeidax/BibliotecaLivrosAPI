package com.rmalmeidax.biblioteca.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioDTO {

	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank(message = "Preencha o campo nome.")
	private String nome;

	@Email(message = "Email inválido")
	@NotBlank(message = "Preencha o campo email.")
	private String email;
	
	@Valid
	private LoginDTO loginDTO;

}
