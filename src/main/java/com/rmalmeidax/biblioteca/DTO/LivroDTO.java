package com.rmalmeidax.biblioteca.DTO;

import java.util.List;

import com.rmalmeidax.biblioteca.entity.Emprestimo;
import com.rmalmeidax.biblioteca.enums.CategoriaEnums;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroDTO {

	private Long id;
	@NotBlank(message = "Preencha o campo nome.")
	private String nome;
	private CategoriaEnums categoriaEnums;
	private List<AutorDTO> autores;
	private List<Emprestimo> emprestimos;

}
