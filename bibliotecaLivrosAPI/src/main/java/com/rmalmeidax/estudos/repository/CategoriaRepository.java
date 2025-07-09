package com.rmalmeidax.estudos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmalmeidax.estudos.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
