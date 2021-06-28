package com.pac3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.entity.Aluno;
import com.pac3.model.AlunoModel;
import com.pac3.repository.AlunoRepository;
import com.pac3.repository.RankingRepository;

@RestController
@RequestMapping("/pac3")
public class RankingController {

	private RankingRepository rankingRepository;

	public RankingController(RankingRepository rankingRepository) {
		this.rankingRepository = rankingRepository;
	}

	@PostMapping("/ranking")
	List<Aluno> obterAlunos() {
		return rankingRepository.findAll();
	}
}
