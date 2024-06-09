package com.calcio.gestioneFigureCalcistiche.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestioneFigureCalcistiche.entities.AllenatoreEntity;

@Repository
public interface AllenatoreRepository extends JpaRepository<AllenatoreEntity, Long> {
	
	@Query(value = "SELECT * FROM allenatore WHERE id_squadra = ?", nativeQuery = true)
	public AllenatoreEntity findAllenatoreBySquadra(Long squadra);

}
