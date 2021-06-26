package com.pac3.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Aluno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Long totalPontos;
	private Long faseAtual;
	private Long tempoMedioFase;
 
    @ManyToOne @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;
	
	@OneToMany(mappedBy="aluno")
	private Set<Partida> partidas;

}
