package com.pac3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.entity.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{

	Optional<Partida> findById(Long id);

}
