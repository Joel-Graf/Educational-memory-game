package com.pac3.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pac3.model.AlunoModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String usuario;
	private String senha;

	@OneToMany(mappedBy = "professor")
	private List<Aluno> alunos;
	

	public Professor(AlunoModel newProfessor) {
		this.nome=newProfessor.getNome();
		this.usuario=newProfessor.getUsuario();
		this.senha=newProfessor.getSenha();
	}

}
