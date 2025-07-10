package com.rmalmeidax.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.DTO.LoginDTO;
import com.rmalmeidax.biblioteca.entity.Usuario;
import com.rmalmeidax.biblioteca.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById (Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID " + id + "não encontrado"));
	}
	
	public Usuario save (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario findByEmailAndSenha(String email, String senha){
		
		return usuarioRepository.findByEmailAndSenha(email, senha)
				.orElseThrow(() -> new RuntimeException("E-mail ou senha inválido."));
	}
	

}
