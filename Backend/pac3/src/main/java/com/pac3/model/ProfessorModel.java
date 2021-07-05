package com.pac3.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pac3.entity.Aluno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorModel {

	private Long id;
	private String nome;
	private String usuario;
	private String senha;

	@JsonProperty("partidas")
	@JsonManagedReference
	private List<Aluno> alunos;
}
