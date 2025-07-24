package com.rmalmeidax.biblioteca.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rmalmeidax.biblioteca.DTO.LivroDTO;
import com.rmalmeidax.biblioteca.entity.Livro;
import com.rmalmeidax.biblioteca.mapper.LivroMapper;
import com.rmalmeidax.biblioteca.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<LivroDTO> findAll(){
        return livroRepository.findAll().stream()
        		.map(LivroMapper::toDTO)
        		.collect(Collectors.toList());
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID" + id + " não encontrdado"));
        }

   public Livro save (Livro livro){
        
        return livroRepository.save(livro);
   }

   public void deleteById(Long id){
        livroRepository.deleteById(id);
   }

}
