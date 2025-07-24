package com.rmalmeidax.biblioteca.DTO;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO {
	
	private Long id;
	@NotBlank(message = "Preencha o campo nome.")
	private String nome;
	private String nacionalidade;
	private List<LivroDTO> livros;
	 
}
