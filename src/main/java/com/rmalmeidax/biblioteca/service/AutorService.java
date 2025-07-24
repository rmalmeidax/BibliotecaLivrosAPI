package com.rmalmeidax.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmalmeidax.biblioteca.DTO.AutorDTO;
import com.rmalmeidax.biblioteca.entity.Autor;
import com.rmalmeidax.biblioteca.mapper.AutorMapper;
import com.rmalmeidax.biblioteca.repository.AutorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutorService {

	private final AutorRepository autorRepository;

	public Autor findById(Long id) {
		return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao buscar o ID " + id));
	}

	public List<AutorDTO> findAll() {
		return autorRepository.findAll().stream().map(AutorMapper::toDTO).collect(Collectors.toList());
	}

	@Transactional
	public Autor save(Autor autor) {
		if (autor.getNome() == null && autor.getNacionalidade() == null) {
			throw new RuntimeException("Preencha o campo Nome do Autor");
		}
		return autorRepository.save(autor);
	}

	@Transactional
	public void deleteById(Long id) {
		autorRepository.deleteById(id);
	}

}
