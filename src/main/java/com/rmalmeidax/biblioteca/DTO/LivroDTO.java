package com.rmalmeidax.biblioteca.DTO;

import com.rmalmeidax.biblioteca.enums.Categoria;
import com.rmalmeidax.biblioteca.enums.Situacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {

    private Long id;
    private String nome;
    private Categoria categoria;
    private Situacao situacao;
}
