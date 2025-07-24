package com.rmalmeidax.biblioteca.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
	
	private Long id;

	@NotBlank(message = "Campo inválido preencha o campo email.")
	@Email(message = "Email inválido.")
	private String email;

	@NotBlank(message = "Campo inválido preencha o campo senha.")
	@Size(min = 4, max = 8, message = "A senha deve conter no minimo 04 e no maximo 08 caracters.")
	private String senha;
}
