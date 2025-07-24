package com.rmalmeidax.biblioteca.projection;

import com.rmalmeidax.biblioteca.enums.CategoriaEnums;

public interface LivroProjection {

    Long getId();
    String getNome();
    CategoriaEnums getCategoriaEnums();
}
   
