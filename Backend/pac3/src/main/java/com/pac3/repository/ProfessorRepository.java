package com.pac3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	Optional<Professor> findByUsuario(String usuario);
	Optional<Professor> findBySenha(String senha);
	
}
