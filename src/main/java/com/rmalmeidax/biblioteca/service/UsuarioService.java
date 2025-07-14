package com.rmalmeidax.biblioteca.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.entity.Usuario;
import com.rmalmeidax.biblioteca.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + "não encontrado"));
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario autenticar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("E-mail inválido."));

		if (!bCryptPasswordEncoder.matches(senha, usuario.getSenha())) {
			throw new RuntimeException("Senha Inválida");
		}
		return usuario;
	}

}
