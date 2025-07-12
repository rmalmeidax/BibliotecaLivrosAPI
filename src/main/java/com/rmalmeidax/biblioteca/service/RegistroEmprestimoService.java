package com.rmalmeidax.biblioteca.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.entity.Livro;
import com.rmalmeidax.biblioteca.entity.RegistroEmprestimo;
import com.rmalmeidax.biblioteca.repository.RegistroEmprestimoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistroEmprestimoService {

	private final RegistroEmprestimoRepository registroEmprestimoRepository;

	public List<RegistroEmprestimo> findAll() {
		return registroEmprestimoRepository.findAll();

	}

	public RegistroEmprestimo findById(Long id) {
		return registroEmprestimoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID " + id + "não localizado"));

	}

	public void deleteById(Long id) {
		registroEmprestimoRepository.deleteById(id);

	}

	public RegistroEmprestimo save(RegistroEmprestimo registroEmprestimo) {
		registroEmprestimo.setDataDevolucao(registroEmprestimo.getDataEmprestimo().plusDays(5));
		return registroEmprestimoRepository.save(registroEmprestimo);
	}

	public void livroEmprestado(Long idRegistro) {
		RegistroEmprestimo registro = registroEmprestimoRepository.findById(idRegistro)
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

		if (registro.getDataDevolvida().isAfter(registro.getDataDevolucao())) {

			long diasAtraso = ChronoUnit.DAYS.between(registro.getDataDevolucao(), registro.getDataDevolvida());
			Double multa = diasAtraso * 1.00;
			System.out.println("O valor da multa é de R$ " + multa + "total de dias " + diasAtraso);
		} else {
			System.out.println("Entrega dentro do prazo.");
		}
	}

}	
	

