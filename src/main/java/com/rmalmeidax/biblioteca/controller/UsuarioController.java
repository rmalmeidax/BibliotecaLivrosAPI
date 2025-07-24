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

import com.rmalmeidax.biblioteca.DTO.UsuarioDTO;
import com.rmalmeidax.biblioteca.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(Pageable pageable) {
		List<UsuarioDTO> dto = usuarioService.findAll();
		return ResponseEntity.ok(dto);

	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
		UsuarioDTO userNew = usuarioService.findById(id);

		UsuarioDTO userDto = new UsuarioDTO();
		userDto.setId(userNew.getId());
		userDto.setNome(userNew.getNome());
		userDto.setEmail(userNew.getEmail());

		return ResponseEntity.ok(userDto);

	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioDTO usuarioDto) {
		UsuarioDTO response = usuarioService.save(usuarioDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();

	}

}
