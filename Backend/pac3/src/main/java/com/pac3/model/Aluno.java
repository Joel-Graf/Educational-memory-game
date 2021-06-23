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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(Long totalPontos) {
		this.totalPontos = totalPontos;
	}

	public Long getFaseAtual() {
		return faseAtual;
	}

	public void setFaseAtual(Long faseAtual) {
		this.faseAtual = faseAtual;
	}

	public Long getTempoMedioFase() {
		return tempoMedioFase;
	}

	public void setTempoMedioFase(Long tempoMedioFase) {
		this.tempoMedioFase = tempoMedioFase;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Set<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(Set<Partida> partidas) {
		this.partidas = partidas;
	}

	
	

}
