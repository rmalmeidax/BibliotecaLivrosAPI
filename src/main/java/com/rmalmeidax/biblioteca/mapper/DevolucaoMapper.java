package com.rmalmeidax.biblioteca.mapper;

import com.rmalmeidax.biblioteca.DTO.DevolucaoDTO;
import com.rmalmeidax.biblioteca.entity.Devolucao;

public class DevolucaoMapper {
	
	public static Devolucao toEntity (DevolucaoDTO dto) {
		if (dto == null) return null;
			
			Devolucao devolucao = new Devolucao();
			devolucao.setDataDevolvida(dto.getDataDevolvida());
			devolucao.setId(dto.getId());
			devolucao.setMulta(dto.getMulta());
			devolucao.setSituacaoEnums(dto.getSituacao());
			devolucao.setFinanceiroEnums(dto.getFinanceiro());
			
			if (dto.getEmprestimo() != null) {
				devolucao.setEmprestimo(EmprestimoMapper.toEntity(dto.getEmprestimo()));
			}
			return devolucao;
	}
	
	public static DevolucaoDTO toDTO (Devolucao devolucao) {
		if (devolucao == null) return null;
		
		DevolucaoDTO dto = new DevolucaoDTO();
		
		dto.setDataDevolvida(devolucao.getDataDevolvida());
		dto.setFinanceiro(devolucao.getFinanceiroEnums());
		dto.setId(devolucao.getId());
		dto.setMulta(devolucao.getMulta());
		dto.setSituacao(devolucao.getSituacaoEnums());
		
		if (devolucao.getEmprestimo() != null) {
			dto.setEmprestimo(EmprestimoMapper.toDTO(devolucao.getEmprestimo()));
		}
		
		return dto;
	}
}

