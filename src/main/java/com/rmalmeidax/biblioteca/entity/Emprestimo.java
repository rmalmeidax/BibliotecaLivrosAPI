package com.rmalmeidax.biblioteca.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rmalmeidax.biblioteca.enums.CategoriaEnums;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private int qtdLivrosEmprestados;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEmprestimo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolucao;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "tb_registro_usuario", joinColumns = @JoinColumn(name = "registro_id"), inverseJoinColumns = @JoinColumn(name = "livro_id"))
	private List<Livro> livros;

	@OneToOne(mappedBy = "emprestimo")
	private Devolucao devolucao;

	@Enumerated(EnumType.STRING)
	private CategoriaEnums categoriaEnums;

}
