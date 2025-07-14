package com.rmalmeidax.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name ="tb_login")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@Email
	@NotBlank(message = "Campo inválido, preencha o email.")
	private String email;

	@NotBlank(message = "Preencha o campo senha é obrigátorio.")
	@Size(min = 4, max = 8, message = "Prencha o campo senha minimo 04 e maximo 08.")
	private String senha;

	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
