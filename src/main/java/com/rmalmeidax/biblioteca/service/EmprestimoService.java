package com.rmalmeidax.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.DTO.EmprestimoDTO;
import com.rmalmeidax.biblioteca.entity.Emprestimo;
import com.rmalmeidax.biblioteca.entity.Livro;
import com.rmalmeidax.biblioteca.mapper.EmprestimoMapper;
import com.rmalmeidax.biblioteca.repository.EmprestimoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

	private final EmprestimoRepository emprestimoRepository;

	public List<EmprestimoDTO> findAll() {
		return emprestimoRepository.findAll()
				.stream()
				.map(EmprestimoMapper::toDTO)
				.collect(Collectors.toList());

	}

	public Emprestimo findById(Long id) {
		return emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + "não localizado"));

	}

	public void deleteById(Long id) {
		emprestimoRepository.deleteById(id);

	}

	public Emprestimo save(Emprestimo emprestimo) {
		emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
		return emprestimoRepository.save(emprestimo);
	}

	public void livroEmprestado(Long idRegistro) {
		Emprestimo registro = emprestimoRepository.findById(idRegistro)
				.orElseThrow(() -> new RuntimeException("Erro ao encontrar livro com ID"));

		if (registro.getQtdLivrosEmprestados() > 3 || registro.getQtdLivrosEmprestados() < 0) {
			System.out.println("Revise a quantidade de livros desejada.");
		} else {
			for (int i = 0; i < registro.getQtdLivrosEmprestados(); i++) {
				Livro livro = registro.getLivros().get(i);
				if (livro.getNome() == null || livro.getNome().isBlank()) {
					throw new RuntimeException("Não pode haver livro em branco (sem nome).");
				}
			}
		}

		
	}

}
