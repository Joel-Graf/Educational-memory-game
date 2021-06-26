package com.pac3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.model.Log;
import com.pac3.model.Professor;
import com.pac3.repository.ProfessorRepository;

@RestController
@RequestMapping("/pac3")
public class ProfessorController {

	private final ProfessorRepository professorRepository;
	
	ProfessorController(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@GetMapping("/professor/todos")
	List<Professor> all() {
		return professorRepository.findAll();
	}

	@PostMapping("/professor/logar")
	Object logar(@RequestBody Professor newProfessor) {
		
		try {
			professorRepository.findByUsuario(newProfessor.getUsuario());
		} catch (Exception e) {
			return new Log(false, "O seu usuário está errado!");
		}
		
		try {
			professorRepository.findBySenha(newProfessor.getSenha());
		} catch (Exception e) {
			return new Log(false, "Sua senha está errado!");
		}
		
		return new Log(true, "Usuário logado!");
	}
	
	@PostMapping("/professor/cadastrar")
	Object cadastrar(@RequestBody Professor newProfessor) { 

		Professor professor = new Professor();
		professor.setNome(newProfessor.getNome());
		professor.setUsuario(newProfessor.getUsuario());
		professor.setSenha(newProfessor.getSenha());
		try {
			professorRepository.save(professor);
		} catch (Exception e) {
			return new Log(false, "Algo deu errado, segue o erro: " + e);
		}
		return new Log(true, "Cadastro bem sucedido!");
	}

	@GetMapping("/professor/deletar/{id}")
	void deleteProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}
	
}