package com.rmalmeidax.biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmalmeidax.biblioteca.DTO.RegistroEmprestimoDTO;
import com.rmalmeidax.biblioteca.entity.RegistroEmprestimo;
import com.rmalmeidax.biblioteca.service.RegistroEmprestimoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class RegistroEmprestimoController {

	private final RegistroEmprestimoService registroEmprestimoService;

	@GetMapping
	public List<RegistroEmprestimo> findAll() {
		return registroEmprestimoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistroEmprestimoDTO> findById(@PathVariable Long id) {
		RegistroEmprestimo emprestimo = registroEmprestimoService.findById(id);

		RegistroEmprestimoDTO emprestimoDTO = new RegistroEmprestimoDTO();

		emprestimoDTO.setCategoriaEnums(emprestimo.getCategoriaEnums());
		emprestimoDTO.setDataDevolucao(emprestimo.getDataDevolucao());
		emprestimoDTO.setDataDevolvida(emprestimo.getDataDevolvida());
		emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoDTO.setFinanceiroEnums(emprestimo.getFinanceiroEnums());
		emprestimoDTO.setId(emprestimo.getId());
		emprestimoDTO.setLivros(emprestimo.getLivros());
		emprestimoDTO.setMulta(emprestimo.getMulta());
		emprestimoDTO.setQtdLivrosEmprestados(emprestimo.getQtdLivrosEmprestados());
		emprestimoDTO.setSituacaoEnums(emprestimo.getSituacaoEnums());
		emprestimoDTO.setUsuario(emprestimo.getUsuario());

		return ResponseEntity.ok(emprestimoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		registroEmprestimoService.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<RegistroEmprestimoDTO> save(@RequestBody RegistroEmprestimo registro) {
		RegistroEmprestimo emprestimo = registroEmprestimoService.save(registro);

		RegistroEmprestimoDTO emprestimoDTO = new RegistroEmprestimoDTO();

		emprestimoDTO.setCategoriaEnums(emprestimo.getCategoriaEnums());
		emprestimoDTO.setDataDevolucao(emprestimo.getDataDevolucao());
		emprestimoDTO.setDataDevolvida(emprestimo.getDataDevolvida());
		emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoDTO.setFinanceiroEnums(emprestimo.getFinanceiroEnums());
		emprestimoDTO.setId(emprestimo.getId());
		emprestimoDTO.setLivros(emprestimo.getLivros());
		emprestimoDTO.setMulta(emprestimo.getMulta());
		emprestimoDTO.setQtdLivrosEmprestados(emprestimo.getQtdLivrosEmprestados());
		emprestimoDTO.setSituacaoEnums(emprestimo.getSituacaoEnums());
		emprestimoDTO.setUsuario(emprestimo.getUsuario());

		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoDTO);

	}

}
