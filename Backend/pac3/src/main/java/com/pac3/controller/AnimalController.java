package com.pac3.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac3.model.Animal;
import com.pac3.model.Professor;
import com.pac3.repository.AnimalRepository;

@RestController
@RequestMapping("/pac3")
public class AnimalController {

	private AnimalRepository animalRepository;

	AnimalController(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	@GetMapping("/professores")
	List<Animal> all() {
		return animalRepository.findAll();
	}

	@GetMapping("/professores/{id}")
	Animal one(@PathVariable Long id) {

		return animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@PutMapping("/professores")
	Professor createProfessor(@RequestBody Animal professor) {
		return animalRepository.save(professor);
	}
	
	@PutMapping("/professores/{id}")
	Professor replaceProfessor(@RequestBody Professor newProfessor, @PathVariable Long id) {

		return animalRepository.findById(id).map(Professor -> {
			Professor.setNome(newProfessor.getNome());
			return animalRepository.save(Professor);
		}).orElseGet(() -> {
			newProfessor.setId(id);
			return animalRepository.save(newProfessor);
		});
	}

	@DeleteMapping("/professores/{id}")
	void deleteProfessor(@PathVariable Long id) {
		animalRepository.deleteById(id);
	}
}