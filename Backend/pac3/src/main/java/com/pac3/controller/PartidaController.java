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
	
	@PostMapping("/startGame")
	public ResponseEntity<?> finishGame(@RequestBody PartidaModel newPartida) {
		partidaRepository.save(new Partida("ANDAMENTO",0l,
				alunoRepository.findById(newPartida.getAlunoId()).orElse(null), 
				biomaRepository.findById(newPartida.getBiomaId()).orElse(null), 
				dificuldadeRepository.findById(newPartida.getDifuculdadeId()).orElse(null))
		);

		Partida partidaAtual = partidaRepository.getById(partidaRepository.count());
		ArrayList<Partida> partidasAluno = new ArrayList<Partida>();
		Aluno aluno = alunoRepository.findById(newPartida.getAlunoId()).orElse(null);
		partidasAluno.add(partidaAtual);
		aluno.setPartidas(partidasAluno);
		alunoRepository.save(aluno);
		
		return new ResponseEntity<>(partidaAtual.getId(), HttpStatus.OK);
	}
	
	@PostMapping("/finishGame")
	public ResponseEntity<?> startGame(@RequestBody PartidaModel newPartida) {

		Partida partidaAtual = partidaRepository.getById(newPartida.getId());
		partidaAtual.setStatus(newPartida.getStatus());
		partidaAtual.setTempoJogado(newPartida.getTempoJogado());
		partidaRepository.save(partidaAtual);
		
		List<Partida> partidasBanco = partidaRepository.findAll();
		List<Partida>  partidasAluno = new ArrayList<Partida>();
		for (Partida partidaBanco : partidasBanco) {
			if ((partidaBanco.getAluno()!=null)&&(partidaBanco.getAluno().getId()==newPartida.getAlunoId())) {
				partidasAluno.add(partidaBanco);
			}
		}
		List<Long> tempos = new ArrayList<Long>();
		
		for (Partida partidaAluno : partidasAluno) {
			tempos.add(partidaAluno.getTempoJogado());
		}
		
		Long soma = 0l;
		Long tempoMedio = 0l;
		for (Long tempo : tempos) {
			if(tempo!=null) { soma+=tempo; }
		}
		if (tempos.size()!=0) { tempoMedio=soma/tempos.size(); }
		
		Aluno aluno  = alunoRepository.findById(newPartida.getAlunoId()).orElse(null);
		aluno.setTempoMedio(tempoMedio);
		partidasAluno.add(partidaAtual);
		aluno.setPartidas(partidasAluno);
		alunoRepository.save(aluno);
		
		return new ResponseEntity<>(true, HttpStatus.CREATED);
	}
}
