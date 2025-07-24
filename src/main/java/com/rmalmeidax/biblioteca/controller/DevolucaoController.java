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

import com.rmalmeidax.biblioteca.DTO.DevolucaoDTO;
import com.rmalmeidax.biblioteca.entity.Devolucao;
import com.rmalmeidax.biblioteca.service.DevolucaoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/devolucao")
@RequiredArgsConstructor
public class DevolucaoController {

	private final DevolucaoService devolucaoService;

	@GetMapping
	public ResponseEntity <List<DevolucaoDTO>> findAll(Pageable pageable) {
		List <DevolucaoDTO> dto = devolucaoService.findAll();
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DevolucaoDTO> findById(@PathVariable Long id) {
		Devolucao devolucao = devolucaoService.findById(id);

		DevolucaoDTO dto = new DevolucaoDTO();

		dto.setDataDevolvida(devolucao.getDataDevolvida());
		dto.setFinanceiro(devolucao.getFinanceiroEnums());
		dto.setId(devolucao.getId());
		dto.setMulta(devolucao.getMulta());
		dto.setSituacao(devolucao.getSituacaoEnums());

		return ResponseEntity.ok(dto);

	}

	@DeleteMapping("/{id}")

	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		devolucaoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<DevolucaoDTO> save(@Valid @RequestBody Devolucao devolucao) {
		Devolucao devolucaoSave = devolucaoService.save(devolucao);

		DevolucaoDTO dto = new DevolucaoDTO();

		dto.setDataDevolvida(devolucaoSave.getDataDevolvida());
		dto.setFinanceiro(devolucaoSave.getFinanceiroEnums());
		dto.setId(devolucaoSave.getId());
		dto.setMulta(devolucaoSave.getMulta());
		dto.setSituacao(devolucaoSave.getSituacaoEnums());

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);

	}

}
