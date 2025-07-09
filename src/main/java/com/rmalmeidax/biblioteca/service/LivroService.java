package com.rmalmeidax.biblioteca.service;


import com.rmalmeidax.biblioteca.entity.Livro;
import com.rmalmeidax.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> findAll(){
        return livroRepository.findAll();
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
