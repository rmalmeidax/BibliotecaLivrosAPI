package com.rmalmeidax.biblioteca.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rmalmeidax.biblioteca.enums.CategoriaEnums;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	@NotBlank(message = "Preencha o campo nome.")
	private String nome;

	@ManyToMany(mappedBy = "livros")
	@JsonManagedReference
	private List<Autor> autores;
	
	
	@ManyToMany(mappedBy = "livros")
	@JsonIgnore
	private List<Emprestimo> emprestimos;
	
	@Enumerated(EnumType.STRING)
	private CategoriaEnums categoriaEnums;

}