package com.rmalmeidax.biblioteca.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.entity.Login;
import com.rmalmeidax.biblioteca.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final LoginRepository loginRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public boolean autenticar(String email, String senha) {
		Optional<Login> loginOPT = loginRepository.findByEmail(email);
		if (loginOPT.isPresent()) {
			String senhaHash = loginOPT.get().getSenha();
			return bCryptPasswordEncoder.matches(senha, senhaHash);

		}
		return false;
	}

}
