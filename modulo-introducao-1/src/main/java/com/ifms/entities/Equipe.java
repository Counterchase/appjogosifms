package com.ifms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "tb_equipe")
public class Equipe implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name= "nome_time")
	private String nomeTime;
	
	@ManyToOne
	@JoinColumn(name = "id_tecnico_fk")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "id_escola_fk")
	private Escola escola;
	
	@ManyToMany
	@JoinColumn(name = "id_atleta_fk")
	private List<Atleta> atleta;
	
	@ManyToOne
	@JoinColumn(name = "id_modalidade_fk")
	private Modalidade modalidade;
	
}