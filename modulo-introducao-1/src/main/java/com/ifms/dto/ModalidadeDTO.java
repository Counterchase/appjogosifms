package com.ifms.dto;

import java.io.Serializable;

import com.ifms.entities.Modalidade;

public class ModalidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descicao;
	
	private void ModalidadeDTO() {

	}

	public ModalidadeDTO(Long id, String descicao) {
		this.id = id;
		this.descicao = descicao;
	}
	public ModalidadeDTO(Modalidade entity) {
		this.id = entity.getId();
		this.descicao = entity.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescicao() {
		return descicao;
	}

	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}

	
}
