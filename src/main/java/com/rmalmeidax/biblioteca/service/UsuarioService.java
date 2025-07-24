package com.rmalmeidax.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.DTO.UsuarioDTO;
import com.rmalmeidax.biblioteca.entity.Usuario;
import com.rmalmeidax.biblioteca.mapper.UsuarioMapper;
import com.rmalmeidax.biblioteca.repository.UsuarioRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init () {
		criptografarSenhasAntigas();
		}
	
	public void criptografarSenhasAntigas() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		for(Usuario usuario : usuarios ) {
			String senhaAtual = usuario.getSenha();
		
		
			if(!senhaAtual.startsWith("$2a$")) {
				String senhaCriptografada = passwordEncoder.encode(senhaAtual);
				usuario.setSenha(senhaCriptografada);
				usuarioRepository.save(usuario);
				}
		}
	}	

	public List<UsuarioDTO> findAll() {
		return usuarioRepository.findAll()
				.stream()
				.map(UsuarioMapper::toDTO)
				.collect(Collectors.toList());
	}

	public UsuarioDTO findById(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ID " + id + " não encontrado"));
		return UsuarioMapper.toDTO(usuario);
	}

	public UsuarioDTO save(UsuarioDTO usuarioDto) {
		Usuario usuario = UsuarioMapper.toEntity(usuarioDto);
		
		
		String cripto = bCryptPasswordEncoder.encode(usuarioDto.getSenha());
		usuario.setSenha(cripto);
		
		
		Usuario saved = usuarioRepository.save(usuario);
		return UsuarioMapper.toDTO(saved);
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	public UsuarioDTO autenticar(String email, String senha) {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("E-mail inválido."));

		if (!bCryptPasswordEncoder.matches(senha, usuario.getSenha())) {
			throw new RuntimeException("Senha Inválida");
		}
		return UsuarioMapper.toDTO(usuario);
	}

}
