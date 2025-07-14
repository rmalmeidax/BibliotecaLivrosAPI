package com.rmalmeidax.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmalmeidax.biblioteca.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long>{

}
