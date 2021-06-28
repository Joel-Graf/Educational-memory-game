package com.pac3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac3.entity.Bioma;

@Repository
public interface BiomaRepository  extends JpaRepository<Bioma, Long>{

}
