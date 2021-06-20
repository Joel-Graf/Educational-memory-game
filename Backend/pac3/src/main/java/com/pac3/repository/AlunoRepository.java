package com.pac3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
