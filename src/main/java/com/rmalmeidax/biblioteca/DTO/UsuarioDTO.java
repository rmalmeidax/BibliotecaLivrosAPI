package com.rmalmeidax.biblioteca.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private Long id;

	@NotBlank(message = "Preencha o campo nome.")
	private String nome;

	@Email(message = "Email inválido")
	@NotBlank(message = "Preencha o campo email.")
	private String email;

	@NotBlank(message = "Preencha o campo senha.")
	@Size(min = 4, max = 8, message = "Senha no minimo 04 digitos e maximo 08 digitos.")
	private String senha;

}
