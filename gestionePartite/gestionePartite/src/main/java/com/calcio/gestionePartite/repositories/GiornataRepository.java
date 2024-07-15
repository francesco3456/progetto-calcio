package com.calcio.gestionePartite.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestionePartite.entities.GiornataEntity;

@Repository
public interface GiornataRepository extends JpaRepository<GiornataEntity, Long> {
	
	@Query(value = "SELECT num_giornata FROM giornata", nativeQuery = true)
	public List<Integer> findAllNumGiornate();

}
