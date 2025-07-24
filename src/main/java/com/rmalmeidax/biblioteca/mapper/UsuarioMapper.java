package com.rmalmeidax.biblioteca.mapper;

import com.rmalmeidax.biblioteca.DTO.UsuarioDTO;
import com.rmalmeidax.biblioteca.entity.Usuario;

public class UsuarioMapper {

	public static UsuarioDTO toDTO(Usuario usuario) {
		if (usuario == null) return null;
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setId(usuario.getId());
		dto.setEmail(usuario.getEmail());
		dto.setNome(usuario.getNome());
		dto.setCpf(usuario.getCpf());
		

	
		return dto;
	}

	public static Usuario toEntity(UsuarioDTO dto) {

		if (dto == null) return null;
		Usuario usuario = new Usuario();
		
		usuario.setId(dto.getId());
		usuario.setCpf(dto.getCpf());
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(dto.getSenha());
		
		
		return usuario;
	}
}
