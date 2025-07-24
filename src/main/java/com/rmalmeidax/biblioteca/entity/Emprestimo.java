package com.rmalmeidax.biblioteca.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
	@JoinTable(name = "tb_emprestimo_usuario", joinColumns = @JoinColumn(name = "emprestimo_id"), inverseJoinColumns = @JoinColumn(name = "livro_id"))
	private List<Livro> livros;

	@OneToOne(mappedBy = "emprestimo",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Devolucao devolucao;

}
