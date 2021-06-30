package com.pac3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankingModel {

	private Long id;
	private Long nome;
	private Long fase;
	private Long tempoMedio;
	
}
