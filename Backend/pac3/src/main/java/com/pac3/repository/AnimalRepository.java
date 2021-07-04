package com.pac3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.entity.Animal;
import com.pac3.entity.Bioma;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	Optional<Animal> findById(Long id);
	List<Animal> findByNome(String nome);
	List<Animal> findByBioma(Optional<Bioma> bioma);
}
