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

import com.rmalmeidax.biblioteca.DTO.LivroDTO;
import com.rmalmeidax.biblioteca.entity.Livro;
import com.rmalmeidax.biblioteca.service.LivroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;



    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(Pageable pageable){
    	List<LivroDTO> dto = livroService.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById (@PathVariable Long id){
        Livro livro = livroService.findById(id);

        LivroDTO livroDto = new LivroDTO();
        livroDto.setNome(livro.getNome());
        return ResponseEntity.ok(livroDto);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> save(@Valid @RequestBody Livro livro){
        Livro newlivro = livroService.save(livro);

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setNome(newlivro.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(livroDTO);
    }

    @DeleteMapping
    public ResponseEntity<LivroDTO> deleteById (@PathVariable Long id){
       livroService.deleteById(id);
       return ResponseEntity.noContent().build();


    }
}
