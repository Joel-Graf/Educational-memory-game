package com.pac3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.entity.Aluno;
import com.pac3.model.RankingModel;
import com.pac3.repository.RankingRepository;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/pac3")
public class RankingController {

	private RankingRepository rankingRepository;

	public RankingController(RankingRepository rankingRepository) {
		this.rankingRepository = rankingRepository;
	}

	@PostMapping("/ranking")
	List<RankingModel> obterAlunos() {
		List<Aluno> alunos = rankingRepository.findAll();
		List<RankingModel> ranking = new ArrayList<RankingModel>();
		
		for (Aluno aluno : alunos) {
			ranking.add(new RankingModel(aluno.getId(), aluno.getNome(), aluno.getFase(), aluno.getTempoMedio()));
		}
		
		return ranking;
	}
}
