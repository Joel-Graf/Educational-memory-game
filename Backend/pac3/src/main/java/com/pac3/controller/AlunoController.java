package com.pac3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.entity.Aluno;
import com.pac3.model.AlunoModel;
import com.pac3.repository.AlunoRepository;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/pac3")
public class AlunoController {

	private final AlunoRepository alunoRepository;
	
	AlunoController(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@PostMapping("/aluno/login")
	 public ResponseEntity<?> logar(@RequestBody AlunoModel newAluno) {

		Aluno aluno = new Aluno();
		try {
			aluno = alunoRepository.findByUsuario(newAluno.getUsuario());
			if (aluno.getSenha().equals(newAluno.getSenha())) {
				return new ResponseEntity<>(aluno, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			
		}
		
	}
	
	@PostMapping("/aluno/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody AlunoModel newAluno) {
		
		if(alunoRepository.findByUsuario(newAluno.getUsuario()) != null) return new ResponseEntity<>(false, HttpStatus.LOCKED);
		if(alunoRepository.findByNome(newAluno.getNome()) != null) return new ResponseEntity<>(false, HttpStatus.LOCKED);
		
		newAluno.setTempoMedioFase(0l);
		newAluno.setFase(1l);
		newAluno.setTotalPontos(0l);
		
		alunoRepository.save(new Aluno(newAluno));
		return new ResponseEntity<>(true, HttpStatus.CREATED);
		
	}
	
}