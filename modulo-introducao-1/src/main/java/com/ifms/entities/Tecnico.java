package com.ifms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tecnico")
public class Tecnico extends Pessoa<Long> {
	private static final long serialVersionUID = 1L;
	
	private Boolean arbitro;
	
	@OneToMany(mappedBy = "tecnico")
	private List<Equipe> equipe;

	public boolean isArbitro() {
		return arbitro;
	}

	public void setArbitro(boolean arbitro) {
		this.arbitro = arbitro;
	}

	
}
