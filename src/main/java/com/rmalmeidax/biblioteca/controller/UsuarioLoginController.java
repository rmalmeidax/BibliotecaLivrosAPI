package com.rmalmeidax.biblioteca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmalmeidax.biblioteca.DTO.LoginDTO;
import com.rmalmeidax.biblioteca.DTO.UsuarioDTO;
import com.rmalmeidax.biblioteca.entity.Usuario;
import com.rmalmeidax.biblioteca.service.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UsuarioLoginController {

	private final UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<?> findByEmailAndSenha(@Valid @RequestBody LoginDTO loginDTO) {

		try {
			Usuario userNew = usuarioService.findByEmailAndSenha(loginDTO.getEmail(), loginDTO.getSenha());

			UsuarioDTO userDto = new UsuarioDTO();
			userDto.setEmail(userNew.getEmail());
			userDto.setNome(userNew.getNome());
			userDto.setId(userNew.getId());

			return ResponseEntity.ok(userDto);

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
