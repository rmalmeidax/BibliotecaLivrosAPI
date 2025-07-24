package com.rmalmeidax.biblioteca.service;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.DTO.LoginDTO;
import com.rmalmeidax.biblioteca.entity.Usuario;
import com.rmalmeidax.biblioteca.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	
	private final UsuarioRepository usuarioRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public String login (LoginDTO dto) {
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail())
			.orElseThrow(() -> new RuntimeException("Email não encontrado. " + dto.getEmail()));
		
		if (!bCryptPasswordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
			throw new RuntimeException("Senha Inválida.");
			
		}
		return "Login Realizado com Sucesso.";
		}

}
