package com.rmalmeidax.biblioteca.DTO;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	
	@CPF
	@NotBlank(message = "Preencha o campo CPF")
	private String cpf;
	
	@NotBlank(message = "Preencha o campo senha.")
	@Size(min = 4, max = 255, message = "Senha no minimo 04 digitos e maximo 08 digitos.")
	private String senha;


}
