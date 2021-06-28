package com.pac3.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class DificuldadeModel {

	private Long id;
	private Long numeroCartas;
	private Long tempoLimite;

	@JsonProperty("partidas")
	@JsonManagedReference
	private Set<Partida> partidas;
}
