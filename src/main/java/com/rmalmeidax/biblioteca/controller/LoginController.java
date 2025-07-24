package com.rmalmeidax.biblioteca.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	public ResponseEntity<?> autenticar(@Valid @RequestBody LoginDTO loginDTO) {

		try {
		String autenticado = loginService.login(loginDTO);
			return ResponseEntity.ok(autenticado);
		
	} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senhas inválidos.");
		}

	}

}
