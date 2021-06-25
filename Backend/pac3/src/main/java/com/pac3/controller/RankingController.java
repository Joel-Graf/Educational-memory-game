package com.pac3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.model.Aluno;
import com.pac3.repository.AlunoRepository;

@RestController
@RequestMapping("/pac3")
public class RankingController {

	private AlunoRepository alunoRepository;

	RankingController(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@GetMapping("/ranking")
	List<Aluno> obterAlunos() {
		try {
			return alunoRepository.findAll();
		} catch (Exception e) {
			return alunoRepository.findAll();
		}
	}
	
}
