package com.rmalmeidax.biblioteca.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmalmeidax.biblioteca.DTO.AutorDTO;
import com.rmalmeidax.biblioteca.entity.Autor;
import com.rmalmeidax.biblioteca.service.AutorService;

import lombok.RequiredArgsConstructor;

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
	public ResponseEntity <List<AutorDTO>> findAll(Pageable pageable){
		List <AutorDTO> dto = autorService.findAll();
		return ResponseEntity.ok(dto);
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
