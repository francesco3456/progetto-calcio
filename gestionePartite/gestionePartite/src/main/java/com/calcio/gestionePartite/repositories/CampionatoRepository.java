package com.calcio.gestionePartite.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestionePartite.entities.CampionatoEntity;

@Repository
public interface CampionatoRepository extends JpaRepository<CampionatoEntity, Long> {
	
	@Query(value = "SELECT nome FROM campionato", nativeQuery = true)
	public List<String> findAllNomiCampionato();

}
