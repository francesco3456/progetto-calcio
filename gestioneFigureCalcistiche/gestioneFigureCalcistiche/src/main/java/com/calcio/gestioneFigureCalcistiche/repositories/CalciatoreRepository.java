package com.calcio.gestioneFigureCalcistiche.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestioneFigureCalcistiche.entities.CalciatoreEntity;

@Repository
public interface CalciatoreRepository extends JpaRepository<CalciatoreEntity, Long> {
	
	@Query(value = "SELECT * FROM calciatore WHERE id_squadra = ?", nativeQuery = true)
	public List<CalciatoreEntity> findAllCalciatoriBySquadra(Long squadra);

}
