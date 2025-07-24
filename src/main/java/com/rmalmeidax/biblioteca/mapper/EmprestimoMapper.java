package com.rmalmeidax.biblioteca.mapper;

import java.util.stream.Collectors;

import com.rmalmeidax.biblioteca.DTO.EmprestimoDTO;
import com.rmalmeidax.biblioteca.entity.Emprestimo;

public class EmprestimoMapper {

	public static Emprestimo toEntity(EmprestimoDTO dto) {

		if (dto == null)
			return null;

		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setDataDevolucao(dto.getDataDevolucao());
		emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
		emprestimo.setId(dto.getId());
		emprestimo.setQtdLivrosEmprestados(dto.getQtdLivrosEmprestados());

		if (dto.getUsuario() != null) {
			emprestimo.setUsuario(UsuarioMapper.toEntity(dto.getUsuario()));
		}

		if (dto.getLivros() != null) {
			emprestimo.setLivros(dto.getLivros().stream().map(LivroMapper::toEntity).collect(Collectors.toList()));
		}

		if (dto.getDevolucao() != null) {
			emprestimo.setDevolucao(DevolucaoMapper.toEntity(dto.getDevolucao()));
		}
		return emprestimo;

	}

	public static EmprestimoDTO toDTO(Emprestimo emprestimo) {
		if (emprestimo == null)
			return null;

		EmprestimoDTO dto = new EmprestimoDTO();

		dto.setDataDevolucao(emprestimo.getDataDevolucao());
		dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
		dto.setId(emprestimo.getId());
		dto.setQtdLivrosEmprestados(emprestimo.getQtdLivrosEmprestados());

		if (emprestimo.getUsuario() != null) {
			dto.setUsuario(UsuarioMapper.toDTO(emprestimo.getUsuario()));
		}
		if (emprestimo.getLivros() != null) {
			dto.setLivros(emprestimo.getLivros().stream().map(LivroMapper::toDTO).collect(Collectors.toList()));
		}

		if (emprestimo.getDevolucao() != null) {
			dto.setDevolucao(DevolucaoMapper.toDTO(emprestimo.getDevolucao()));

		}
		return dto;
	}

}
