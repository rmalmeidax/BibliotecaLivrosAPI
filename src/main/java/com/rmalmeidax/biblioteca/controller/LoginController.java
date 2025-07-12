package com.rmalmeidax.biblioteca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmalmeidax.biblioteca.DTO.LoginDTO;
import com.rmalmeidax.biblioteca.service.LoginService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	

	public ResponseEntity<?> autenticar(@Valid @RequestBody LoginDTO loginDTO) {

		boolean autenticado = loginService.autenticar(loginDTO.getEmail(), loginDTO.getSenha());

		if (autenticado) {
			return ResponseEntity.ok("Login realizado com sucesso.");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senhas inválidos.");
		}

	}

}
