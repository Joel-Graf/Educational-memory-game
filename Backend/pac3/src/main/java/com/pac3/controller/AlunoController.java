package com.pac3.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.entity.Aluno;
import com.pac3.model.AlunoModel;
import com.pac3.model.LogModel;
import com.pac3.repository.AlunoRepository;
import com.pac3.repository.ProfessorRepository;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/pac3")
public class AlunoController {

	private final AlunoRepository alunoRepository;
	private final ProfessorRepository professorRepository;
	
	AlunoController(AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
		this.alunoRepository = alunoRepository;
		this.professorRepository = professorRepository;
	}

	@PostMapping("/aluno/login")
	 public ResponseEntity<?> logar(@RequestBody Aluno newAluno) {

		Aluno aluno = new Aluno();
		try {
			aluno = alunoRepository.findByUsuario(newAluno.getUsuario());
			if (aluno.getSenha().equals(newAluno.getSenha())) {
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
	
	@PostMapping("/aluno/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody AlunoModel newAluno) {
		
		if(alunoRepository.findByUsuario(newAluno.getUsuario()) != null) return new ResponseEntity<>(false, HttpStatus.LOCKED);
		if(alunoRepository.findByNome(newAluno.getNome()) != null) return new ResponseEntity<>(false, HttpStatus.LOCKED);
		
		alunoRepository.save(new Aluno(newAluno));
		return new ResponseEntity<>(true, HttpStatus.CREATED);
		
	}
	
}