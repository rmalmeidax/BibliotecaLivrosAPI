package com.rmalmeidax.biblioteca.projection;

import com.rmalmeidax.biblioteca.enums.Categoria;

public interface LivroProjection {

    Long getId();
    String getNome();
    Categoria getCategoria();
}
