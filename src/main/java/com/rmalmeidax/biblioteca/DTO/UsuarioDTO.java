package com.rmalmeidax.biblioteca.DTO;

import com.rmalmeidax.biblioteca.entity.RegistroEmprestimo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {

	private Long id;

	@NotBlank(message = "Preencha o campo nome.")
	private String nome;

	@Email(message = "Email inválido")
	@NotBlank(message = "Preencha o campo email.")
	private String email;

}
