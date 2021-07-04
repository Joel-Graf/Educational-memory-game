package com.pac3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.entity.Professor;
import com.pac3.model.AlunoModel;
import com.pac3.repository.ProfessorRepository;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/pac3")
public class ProfessorController {

	private final ProfessorRepository professorRepository;
	
	ProfessorController(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@PostMapping("/professor/login")
	 public ResponseEntity<?> logar(@RequestBody Professor newProfessor) {

		Professor professor = new Professor();
		try {
			professor = professorRepository.findByUsuario(newProfessor.getUsuario());
			if (professor.getSenha().equals(newProfessor.getSenha())) {
				return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
			}
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
			
		}
		
	}
	
	@PostMapping("/professor/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody AlunoModel newProfessor) {
		
		if(professorRepository.findByUsuario(newProfessor.getUsuario()) != null) return new ResponseEntity<>(false, HttpStatus.LOCKED);
		if(professorRepository.findByNome(newProfessor.getNome()) != null) return new ResponseEntity<>(false, HttpStatus.LOCKED);
		
		professorRepository.save(new Professor(newProfessor));
		return new ResponseEntity<>(true, HttpStatus.CREATED);
		
	}
	
}