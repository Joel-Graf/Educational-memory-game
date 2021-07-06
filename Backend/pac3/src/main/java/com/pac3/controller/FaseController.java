package com.pac3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.entity.Bioma;
import com.pac3.repository.BiomaRepository;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/pac3")
public class FaseController {

	private BiomaRepository biomaRepository;

	public FaseController(BiomaRepository biomaRepository) {
		this.biomaRepository = biomaRepository;
	}

	@PostMapping("/bioma")
	List<Bioma> obterBiomas() {
		//List<Aluno> alunos = biomaRepository.findAll();
		//List<RankingModel> a = new ArrayList<RankingModel>();
		return biomaRepository.findAllByOrderByIdAsc();
	}
}
