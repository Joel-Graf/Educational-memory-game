package com.pac3.entity;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Partida {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long tempo;
	private String status;
	private Long pontos;
	private Long tempoJogado;
	
	@ManyToOne @JoinColumn(name = "id_aluno")
    @JsonManagedReference
    private Aluno aluno;
	
	@ManyToOne @JoinColumn(name = "id_dificuldade")
    @JsonManagedReference
    private Dificuldade dificuldade;
	
	@ManyToOne @JoinColumn(name = "id_bioma")
    @JsonManagedReference
    private Bioma bioma;
	
	public Partida(String status, Long tempoJogado, Aluno aluno, Bioma bioma, Dificuldade dificuldade){
		this.status=status;
		this.pontos=0l;
		this.tempoJogado=tempoJogado;
		this.aluno=aluno;
		this.bioma=bioma;
		this.dificuldade=dificuldade;
	}
}
