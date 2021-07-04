package com.pac3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RankingModel {

	private Long id;
	private String nome;
	private Long fase;
	private Long tempoMedio;

	public RankingModel(Long id, String nome, Long fase, Long tempoMedio) {
		this.id=id;
		this.nome=nome;
		this.fase=fase;
		this.tempoMedio=tempoMedio;
	}
}
