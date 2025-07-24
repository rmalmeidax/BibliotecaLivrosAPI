package com.rmalmeidax.biblioteca.projection;

import java.time.LocalDate;

import com.rmalmeidax.biblioteca.entity.Usuario;

public interface EmprestimoProjection {

	Long getId();

	LocalDate getDataEmprestimo();

	LocalDate getDataDevolucao();

	LocalDate getDataDevolvida();

	Double multa();

	Usuario getUsuario();

	String getUsuarioNome();

}
