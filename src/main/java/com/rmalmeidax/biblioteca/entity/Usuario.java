package com.rmalmeidax.biblioteca.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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

	@NotBlank
	@Size(max = 14)
	//@CPF
	private String cpf;
		
	@Email(message = "Email Invalido")
	@NotBlank(message = "Preencha o campo email.")
	private String email;

	@NotBlank(message = "Preencha o campo senha.")
	@Size(min = 4, max = 255, message = "Senha no minimo 04 digitos e maximo 08 digitos.")
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Emprestimo> emprestimos;

	
	
}
