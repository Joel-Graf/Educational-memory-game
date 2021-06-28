package com.pac3.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pac3.entity.Animal;
import com.pac3.entity.Partida;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BiomaModel {
	
	private Long id;
	private String nome;

	@JsonProperty("partidas")
	private Set<Partida> partidas;

	@JsonProperty("animais")
	private Set<Animal> animais;
}
