package com.rmalmeidax.biblioteca.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank(message = "Preencha o campo nome.")
	private String nome;

	@Email(message = "Email Invalido")
	@NotBlank(message = "Preencha o campo email.")
	private String email;

	
	@NotBlank(message = "Preencha o campo senha.")
	@Size(min = 4,max =8, message = "Senha no minimo 04 digitos e maximo 08 digitos.")
	private String senha;
	
	
	@OneToMany(mappedBy = "usuario")
	private List<RegistroEmprestimo> registroEmprestimo;

}
