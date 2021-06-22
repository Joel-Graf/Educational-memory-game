package com.pac3.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Dificuldade {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroCartas;
	private Long tempoLimite;

	@OneToMany(mappedBy="dificuldade")
	private Set<Partida> partidas;
	
}
