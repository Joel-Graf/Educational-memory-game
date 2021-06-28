package com.pac3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Partida {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
