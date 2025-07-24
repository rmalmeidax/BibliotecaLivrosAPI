package com.rmalmeidax.biblioteca.controller;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmalmeidax.biblioteca.DTO.EmprestimoDTO;
import com.rmalmeidax.biblioteca.entity.Emprestimo;
import com.rmalmeidax.biblioteca.service.EmprestimoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

	private final EmprestimoService emprestimoService;

	@GetMapping
	public ResponseEntity <List<EmprestimoDTO>> findAll(Pageable pageable){
		List <EmprestimoDTO> dto = emprestimoService.findAll();
		return ResponseEntity.ok(dto);
	}		

	@GetMapping("/{id}")
	public ResponseEntity<EmprestimoDTO> findById(@PathVariable Long id) {
		Emprestimo emprestimo = emprestimoService.findById(id);

		EmprestimoDTO emprestimoDTO = new EmprestimoDTO();

		
		emprestimoDTO.setDataDevolucao(emprestimo.getDataDevolucao());
		emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoDTO.setId(emprestimo.getId());
		emprestimoDTO.setQtdLivrosEmprestados(emprestimo.getQtdLivrosEmprestados());
		

		return ResponseEntity.ok(emprestimoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		emprestimoService.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<EmprestimoDTO> save(@RequestBody Emprestimo registro) {
		Emprestimo emprestimo = emprestimoService.save(registro);

		EmprestimoDTO emprestimoDTO = new EmprestimoDTO();

		
		emprestimoDTO.setDataDevolucao(emprestimo.getDataDevolucao());
		emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoDTO.setId(emprestimo.getId());
		emprestimoDTO.setQtdLivrosEmprestados(emprestimo.getQtdLivrosEmprestados());
		

		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoDTO);

	}

}
