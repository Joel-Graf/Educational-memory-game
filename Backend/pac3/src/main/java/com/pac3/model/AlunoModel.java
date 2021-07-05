package com.pac3.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pac3.entity.Partida;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoModel {

	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	private Long totalPontos;
	private Long fase;
	//private Long tempoMedioFase;
    private Long professorId;
   // private ProfessorModel professorModel;
	
	//@JsonProperty("partidas")
	//private Set<Partida> partidas;
}
