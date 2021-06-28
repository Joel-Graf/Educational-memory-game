package com.pac3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidaModel {

	private Long id;
	private Long tempo;
	private String status;
	private Long pontos;
	private Long alunoId;
	private Long difuculdadeId;
	private Long biomaId;
}
