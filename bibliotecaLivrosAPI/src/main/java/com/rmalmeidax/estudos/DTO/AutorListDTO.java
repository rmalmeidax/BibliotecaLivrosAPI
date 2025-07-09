package com.rmalmeidax.estudos.DTO;

import com.rmalmeidax.estudos.entity.AutorList;

public class AutorListDTO {
	
	private Long id;
	private String nome;
	
	
	public AutorListDTO() {
		
	}


	public AutorListDTO(AutorList entity) {
		id =entity.getId();
		nome =entity.getNome();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}
	
	
	
	
	
	

}
