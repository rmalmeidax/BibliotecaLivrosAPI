package com.rmalmeidax.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmalmeidax.biblioteca.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Optional<Login> findByEmail(String email);

}
