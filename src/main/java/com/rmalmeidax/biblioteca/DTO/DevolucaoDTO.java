package com.rmalmeidax.biblioteca.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rmalmeidax.biblioteca.enums.FinanceiroEnums;
import com.rmalmeidax.biblioteca.enums.SituacaoEnums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class DevolucaoDTO {

	@EqualsAndHashCode.Include
	private long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolvida;

	private Double multa;

	private SituacaoEnums situacao;

	private FinanceiroEnums financeiro;
	
	private EmprestimoDTO emprestimo;

}
