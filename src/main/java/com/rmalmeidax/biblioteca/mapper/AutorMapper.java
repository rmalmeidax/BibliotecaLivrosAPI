package com.rmalmeidax.biblioteca.mapper;

import java.util.stream.Collectors;

import com.rmalmeidax.biblioteca.DTO.AutorDTO;
import com.rmalmeidax.biblioteca.entity.Autor;

public class AutorMapper {

	public static Autor toEntity(AutorDTO dto) {
		if (dto == null)
			return null;

		Autor autor = new Autor();

		autor.setId(dto.getId());
		autor.setNacionalidade(dto.getNacionalidade());
		autor.setNome(dto.getNome());

		if (dto.getLivros() != null) {
			autor.setLivros(dto.getLivros().stream().map(LivroMapper::toEntity).collect(Collectors.toList()));
		}
		return autor;
	}

	public static AutorDTO toDTO(Autor autor) {
		if (autor == null)
			return null;

		AutorDTO dto = new AutorDTO();
		dto.setId(autor.getId());
		dto.setNacionalidade(autor.getNacionalidade());
		dto.setNome(autor.getNome());

		if (autor.getLivros() != null) {
			dto.setLivros(autor.getLivros().stream().map(LivroMapper::toDTO).collect(Collectors.toList()));
		}
		return dto;
	}
}
