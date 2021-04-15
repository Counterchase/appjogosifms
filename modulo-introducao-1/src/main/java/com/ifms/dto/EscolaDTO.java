package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.Escola;

public class EscolaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	private void EscolaDTO() {

	}

	public EscolaDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public EscolaDTO(Escola entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
