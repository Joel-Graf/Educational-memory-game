package com.pac3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.entity.Professor;
import com.pac3.model.ProfessorModel;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	Professor findById(ProfessorModel professorModel);
	Professor findByUsuario(String usuario);
	Professor findBySenha(String senha);
	Professor findByNome(String nome);
	
}
