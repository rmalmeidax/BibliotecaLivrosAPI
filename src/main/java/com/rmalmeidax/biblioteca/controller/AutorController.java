package com.rmalmeidax.biblioteca.controller;

import java.util.List;

import com.rmalmeidax.biblioteca.DTO.AutorDTO;
import com.rmalmeidax.biblioteca.entity.Autor;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.rmalmeidax.biblioteca.service.AutorService;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {


	private final AutorService autorService;


	@GetMapping("/{id}")
	public ResponseEntity<AutorDTO> findById(@PathVariable Long id) {
		Autor autor = autorService.findById(id);
		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setId(autor.getId());
		autorDTO.setNome(autor.getNome());
		autorDTO.setNacionalidade(autor.getNacionalidade());

		return ResponseEntity.ok(autorDTO);
	}

	@GetMapping
	public List<Autor> findAll() {
		return autorService.findAll();
	}

	@PostMapping
	public ResponseEntity<AutorDTO> save(@RequestBody Autor autor) {
		Autor newautor = autorService.save(autor);

		AutorDTO autorDTO = new AutorDTO();
		autorDTO.setNome(newautor.getNome());
		autorDTO.setId(newautor.getId());
		autorDTO.setNacionalidade(newautor.getNacionalidade());

		return ResponseEntity.status(HttpStatus.CREATED).body(autorDTO);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		autorService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
