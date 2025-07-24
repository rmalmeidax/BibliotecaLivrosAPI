package com.rmalmeidax.biblioteca.DTO;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmprestimoDTO {

	private Long id;
	private int qtdLivrosEmprestados;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEmprestimo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolucao;

	private UsuarioDTO usuario;
	private List<LivroDTO> livros;
	private DevolucaoDTO devolucao;

}
