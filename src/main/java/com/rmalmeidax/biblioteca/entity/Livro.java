package com.rmalmeidax.biblioteca.entity;

import com.rmalmeidax.biblioteca.enums.Categoria;
import com.rmalmeidax.biblioteca.enums.Situacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	@NotBlank(message = "Preencha o campo nome.")
	private String nome;

}