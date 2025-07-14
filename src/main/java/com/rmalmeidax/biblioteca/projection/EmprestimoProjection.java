package com.rmalmeidax.biblioteca.projection;

import java.time.LocalDate;

import com.rmalmeidax.biblioteca.entity.Usuario;
import com.rmalmeidax.biblioteca.enums.CategoriaEnums;
import com.rmalmeidax.biblioteca.enums.FinanceiroEnums;
import com.rmalmeidax.biblioteca.enums.SituacaoEnums;

public interface EmprestimoProjection {

	Long getId();

	LocalDate getDataEmprestimo();

	LocalDate getDataDevolucao();
	
	LocalDate getDataDevolvida();
	
	Double multa();

	Usuario getUsuario();

	String getUsuarioNome();

	CategoriaEnums getCategoriaEnums();

	FinanceiroEnums getFinanceiroEnums();

	SituacaoEnums getSituacaoEnums();

}
