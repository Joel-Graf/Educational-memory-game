package com.pac3.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Partida {
	
	@Id
	private Long id;
	private Long tempo;
	private String status;
	private Long pontos;
	
	@ManyToOne @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;
	
	@ManyToOne @JoinColumn(name = "id_dificuldade", nullable = false)
    private Dificuldade dificuldade;
	
	@ManyToOne @JoinColumn(name = "id_bioma", nullable = false)
    private Bioma bioma;
	
}
