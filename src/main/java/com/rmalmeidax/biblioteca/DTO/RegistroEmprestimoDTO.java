package com.rmalmeidax.biblioteca.DTO;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rmalmeidax.biblioteca.entity.Livro;
import com.rmalmeidax.biblioteca.entity.Usuario;
import com.rmalmeidax.biblioteca.enums.CategoriaEnums;
import com.rmalmeidax.biblioteca.enums.FinanceiroEnums;
import com.rmalmeidax.biblioteca.enums.SituacaoEnums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RegistroEmprestimoDTO {

	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEmprestimo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolucao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolvida;

	private Usuario usuario;
	private List<Livro> livros;
	private CategoriaEnums categoriaEnums;
	private FinanceiroEnums financeiroEnums;
	private SituacaoEnums situacaoEnums;

	private int qtdLivrosEmprestados;
	
	private Double multa;
}
