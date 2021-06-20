package com.pac3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
	List<Animal> findByNome(String nome);
}
