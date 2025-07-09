package com.rmalmeidax.biblioteca.controller;

import com.rmalmeidax.biblioteca.DTO.LivroDTO;
import com.rmalmeidax.biblioteca.entity.Livro;
import com.rmalmeidax.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;



    @GetMapping
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById (@PathVariable Long id){
        Livro livro = livroService.findById(id);

        LivroDTO livroDto = new LivroDTO();
        livroDto.setNome(livro.getNome());
        livroDto.setCategoria(livro.getCategoria());
        livroDto.setSituacao(livro.getSituacao());
        return ResponseEntity.ok(livroDto);
    }

    @PostMapping
    public ResponseEntity<LivroDTO> save(@RequestBody Livro livro){
        Livro newlivro = livroService.save(livro);

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setSituacao(newlivro.getSituacao());
        livroDTO.setCategoria(newlivro.getCategoria());
        livroDTO.setNome(newlivro.getNome());
        return ResponseEntity.status(HttpStatus.CREATED).body(livroDTO);
    }

    @DeleteMapping
    public ResponseEntity<LivroDTO> deleteById (@PathVariable Long id){
       livroService.deleteById(id);
       return ResponseEntity.noContent().build();


    }
}
