package com.rmalmeidax.biblioteca.entity;

import com.rmalmeidax.biblioteca.enums.Categoria;
import com.rmalmeidax.biblioteca.enums.Situacao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name ="livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String nome;

	@Enumerated (EnumType.STRING)
	private Categoria categoria;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

}