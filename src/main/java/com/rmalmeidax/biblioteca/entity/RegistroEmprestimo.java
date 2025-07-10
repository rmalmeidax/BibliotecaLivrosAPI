package com.rmalmeidax.biblioteca.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rmalmeidax.biblioteca.enums.CategoriaEnums;
import com.rmalmeidax.biblioteca.enums.FinanceiroEnums;
import com.rmalmeidax.biblioteca.enums.SituacaoEnums;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_registro_emprestimo")
public class RegistroEmprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEmprestimo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolucao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolvida;
		
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToMany
	@JoinTable(name = "registro_usuario", joinColumns = @JoinColumn(name = "registro_id"), inverseJoinColumns = @JoinColumn(name = "livro_id"))

	private List<Livro> livros;

	@Enumerated(EnumType.STRING)
	private CategoriaEnums categoriaEnums;

	@Enumerated(EnumType.STRING)
	private FinanceiroEnums financeiroEnums;

	@Enumerated(EnumType.STRING)
	private SituacaoEnums situacaoEnums;

	private int qtdLivrosEmprestados;
	
	private Double multa;
	
}
