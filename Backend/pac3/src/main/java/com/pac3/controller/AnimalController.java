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
import com.pac3.repository.AnimalRepository;

@RestController
@RequestMapping("/pac3")
public class AnimalController {

	private AnimalRepository animalRepository;

	AnimalController(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	@GetMapping("/animal")
	List<Animal> all() {
		return animalRepository.findAll();
	}

	@GetMapping("/animal/{id}")
	Animal one(@PathVariable Long id) {
		return animalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@PutMapping("/animal")
	Animal createProfessor(@RequestBody Animal animal) {
		return animalRepository.save(animal);
	}
	
	@PutMapping("/animal/{id}")
	Animal replaceProfessor(@RequestBody Animal newAnimal, @PathVariable Long id) {

		return animalRepository.findById(id).map(Animal -> {
			Animal.setNome(newAnimal.getNome());
			return animalRepository.save(Animal);
		}).orElseGet(() -> {
			newAnimal.setId(id);
			return animalRepository.save(newAnimal);
		});
	}

	@DeleteMapping("/animal/{id}")
	void deleteProfessor(@PathVariable Long id) {
		animalRepository.deleteById(id);
	}
}