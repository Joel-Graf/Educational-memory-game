package com.pac3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.entity.Aluno;
import com.pac3.entity.Partida;
import com.pac3.model.PartidaModel;
import com.pac3.repository.AlunoRepository;
import com.pac3.repository.BiomaRepository;
import com.pac3.repository.DificuldadeRepository;
import com.pac3.repository.PartidaRepository;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/pac3")
public class PartidaController {

	private final PartidaRepository partidaRepository;
	private final AlunoRepository alunoRepository;
	private final BiomaRepository biomaRepository;
	private final DificuldadeRepository dificuldadeRepository;
	
	PartidaController(PartidaRepository partidaRepository, AlunoRepository alunoRepository, BiomaRepository biomaRepository, DificuldadeRepository dificuldadeRepository) {
		this.partidaRepository = partidaRepository;
		this.alunoRepository = alunoRepository;
		this.biomaRepository = biomaRepository;
		this.dificuldadeRepository = dificuldadeRepository;
	}
	
	@PostMapping("/partida/finishGame")
	public ResponseEntity<?> cadastrar(@RequestBody PartidaModel newPartida) {
		System.out.println(newPartida.getAlunoId());
		System.out.println(newPartida.getBiomaId());
		System.out.println(newPartida.getDifuculdadeId());
		partidaRepository.save(new Partida(
				newPartida.getStatus(),
				newPartida.getTempoJogado(),
				alunoRepository.findById(newPartida.getAlunoId()).orElse(null), 
				biomaRepository.findById(newPartida.getBiomaId()).orElse(null), 
				dificuldadeRepository.findById(newPartida.getDifuculdadeId()).orElse(null))
		);
		
		List<Partida> partidas = partidaRepository.findAll();
		List<Long> tempos = new ArrayList<Long>();
		
		for (Partida partida : partidas) {
			tempos.add(partida.getTempoJogado());
		}
		
		Long soma = 0l;
		Long tempoMedio = 0l;
		for (Long tempo : tempos) {
			soma+=tempo;
		}
		tempoMedio=soma/tempos.size();
		
		Aluno aluno = new Aluno();
		aluno = alunoRepository.findById(newPartida.getAlunoId()).orElse(null);
		aluno.setTempoMedio(tempoMedio);
		alunoRepository.save(aluno);
		
		return new ResponseEntity<>(true, HttpStatus.CREATED);
		
	}
	
}
