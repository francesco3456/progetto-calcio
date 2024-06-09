package com.calcio.gestioneFigureCalcistiche.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestioneFigureCalcistiche.entities.SquadraEntity;

@Repository
public interface SquadraRepository extends JpaRepository<SquadraEntity, Long> {
	
	@Query(value = "SELECT * FROM squadra WHERE nome = ?", nativeQuery = true)
	public SquadraEntity findNomeSquadra(String nome);

}
