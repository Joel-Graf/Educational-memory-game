package com.pac3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@PostMapping("/professor")
	List<Professor> all() {
		return professorRepository.findAll();
	}

	@PostMapping("/professor/{usuario}/{senha}")
	Log logar(@PathVariable String usuario, @PathVariable String senha) {
		try {
			professorRepository.findByUsuario(usuario);
		} catch (Exception e) {
			return new Log(false, "Sua senha está errado!");
		}
		
		try {
			professorRepository.findBySenha(senha);
		} catch (Exception e) {
			return new Log(false, "O seu usuário está errado!");
		}
		return new Log(true, "Parabéns, você esta logado!");
	}
	
	@PutMapping("/professor/{usuario}/{senha}")
	Object cadastrar(@RequestBody Professor newProfessor, String usuario, @PathVariable String senha) {

		Professor professor = new Professor();
		try {
			professor.setNome(newProfessor.getNome());
			professor.setUsuario(newProfessor.getUsuario());
			professor.setSenha(newProfessor.getSenha());
			return professorRepository.save(professor);
		} catch (Exception e) {
			return new Log(false,"Algo deu errado, tente novamente!");
		}
	}

	@DeleteMapping("/professor/{id}")
	void deleteProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}
	
}