package com.pac3.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pac3.model.AlunoModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Aluno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;	
	@Column(nullable = false)
	private String usuario;
	@Column(nullable = false)
	private String senha;
	private Long totalPontos;
	private Long fase;
	//private Long tempoMedioFase;
 
    @ManyToOne @JoinColumn(name = "id_professor")
    @JsonManagedReference
	private Professor professor;
	
    //@OneToMany(mappedBy="aluno")
    //@JsonManagedReference
	//private List<Partida> partidas;

	public Aluno(AlunoModel alunoModel){
		this.nome=alunoModel.getNome();
		this.usuario=alunoModel.getUsuario();
		this.senha=alunoModel.getSenha();
		//this.partidas=null;
		this.totalPontos=0l;
		this.fase=0l;
		this.professor=null;
	}
	
}
