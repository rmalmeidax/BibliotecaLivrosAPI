package com.rmalmeidax.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmalmeidax.biblioteca.entity.Devolucao;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {
	

}
