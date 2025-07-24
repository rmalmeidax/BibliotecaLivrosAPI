package com.rmalmeidax.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmalmeidax.biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {


}
