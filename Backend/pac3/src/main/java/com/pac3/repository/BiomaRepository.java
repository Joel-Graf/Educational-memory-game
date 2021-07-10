package com.pac3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.entity.Bioma;

@Repository
public interface BiomaRepository  extends JpaRepository<Bioma, Long>{

	Optional<Bioma> findById(Long id);
	//Bioma findByBioma(Bioma bioma);
	public List<Bioma> findAllByOrderByIdAsc();
}
