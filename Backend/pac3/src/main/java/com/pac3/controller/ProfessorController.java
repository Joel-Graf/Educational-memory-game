package com.pac3.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.model.Professor;
import com.pac3.repository.ProfessorRepository;

@RestController
@RequestMapping("/pac3")
public class ProfessorController {

	private final ProfessorRepository professorRepository;

	ProfessorController(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@GetMapping("/professores")
	List<Professor> all() {
		return professorRepository.findAll();
	}

	@GetMapping("/professores/{id}")
	Professor one(@PathVariable Long id) {

		return professorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@PutMapping("/professores")
	Professor createProfessor(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}
	
	@PutMapping("/professores/{id}")
	Professor replaceProfessor(@RequestBody Professor newProfessor, @PathVariable Long id) {

		return professorRepository.findById(id).map(Professor -> {
			Professor.setNome(newProfessor.getNome());
			Professor.setUsuario(newProfessor.getUsuario());
			Professor.setSenha(newProfessor.getSenha());
			return professorRepository.save(Professor);
		}).orElseGet(() -> {
			newProfessor.setId(id);
			return professorRepository.save(newProfessor);
		});
	}

	@DeleteMapping("/professores/{id}")
	void deleteProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}

}