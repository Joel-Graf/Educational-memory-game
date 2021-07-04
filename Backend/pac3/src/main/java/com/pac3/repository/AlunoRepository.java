package com.pac3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.entity.Aluno;
import com.pac3.entity.Animal;
import com.pac3.model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Optional<Aluno> findById(Long id);
	Aluno findByUsuario(String usuario);
	Aluno findByNome(String nome);
	Aluno findBySenha(String senha);
	
}
