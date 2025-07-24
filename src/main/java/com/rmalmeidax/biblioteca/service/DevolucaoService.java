package com.rmalmeidax.biblioteca.service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.DTO.DevolucaoDTO;
import com.rmalmeidax.biblioteca.entity.Devolucao;
import com.rmalmeidax.biblioteca.entity.Emprestimo;
import com.rmalmeidax.biblioteca.mapper.DevolucaoMapper;
import com.rmalmeidax.biblioteca.repository.DevolucaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DevolucaoService {

	private final DevolucaoRepository devolucaoRepository;
	private Emprestimo emprestimo;


	public List<DevolucaoDTO> findAll() {
		return devolucaoRepository.findAll()
				.stream()
				.map(DevolucaoMapper:: toDTO)
				.collect(Collectors.toList());
	}

	public Devolucao findById(Long id) {
		return devolucaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao localizar ID" + id));
	}

	public void deleteById(Long id) {
		devolucaoRepository.deleteById(id);
	}

	public Devolucao save (Devolucao devolucao) {
		if (devolucao.getDataDevolvida() != null &&
				emprestimo != null &&
				devolucao.getDataDevolvida().isAfter(emprestimo.getDataDevolucao())) {
			
			long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(),devolucao.getDataDevolvida());
			
			double valorMulta = diasAtraso * 2.00;
			devolucao.setMulta(valorMulta);
			
		} else {
			devolucao.setMulta(0.0);
		}
	return devolucaoRepository.save(devolucao);
		
	}

}
