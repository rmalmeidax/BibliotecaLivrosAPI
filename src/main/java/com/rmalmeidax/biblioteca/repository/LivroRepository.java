package com.rmalmeidax.biblioteca.repository;

import com.rmalmeidax.biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
