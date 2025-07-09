package com.rmalmeidax.estudos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rmalmeidax.estudos.entity.Autor;
import com.rmalmeidax.estudos.projection.AutorMinProjection;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query(nativeQuery = true, value = """
        SELECT a.id, a.nome
        FROM autores a
        INNER JOIN autores_listas al ON a.id = al.autor_id
        WHERE al.lista_id = :listId
    """)
    List<AutorMinProjection> searchByList(@Param("listId") Long listId);
}
