package com.rmalmeidax.biblioteca.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.rmalmeidax.biblioteca.DTO.AutorDTO;
import com.rmalmeidax.biblioteca.DTO.LivroDTO;
import com.rmalmeidax.biblioteca.entity.Autor;
import com.rmalmeidax.biblioteca.entity.Livro;

public class LivroMapper {

	public static LivroDTO toDTO(Livro livro) {

		if (livro == null)
			return null;
		LivroDTO dto = new LivroDTO();

		dto.setCategoriaEnums(livro.getCategoriaEnums());
		dto.setEmprestimos(livro.getEmprestimos());
		dto.setId(livro.getId());
		dto.setNome(livro.getNome());

		if (livro.getAutores() != null) {

			List<AutorDTO> autoresDTO = (livro.getAutores().stream().map(autor -> {
				AutorDTO autorDTO = new AutorDTO();
				autorDTO.setId(autor.getId());
				autorDTO.setNome(autor.getNome());
				return autorDTO;
			}).collect(Collectors.toList()));

			dto.setAutores(autoresDTO);
		}

		return dto;
	}

	public static Livro toEntity(LivroDTO livroDTO) {

		if (livroDTO == null)
			return null;

		Livro livro = new Livro();

		livro.setCategoriaEnums(livroDTO.getCategoriaEnums());
		livro.setNome(livroDTO.getNome());
		livro.setEmprestimos(livroDTO.getEmprestimos());
		livro.setId(livroDTO.getId());

		if (livroDTO.getAutores() != null) {
			livro.setAutores(livroDTO.getAutores().stream().map(autorDTO -> {
				Autor autor = new Autor();
				autor.setId(autorDTO.getId());
				autor.setNome(autorDTO.getNome());
				return autor;

			})

					.collect(Collectors.toList())

			);
		}

		return livro;
	}

}
