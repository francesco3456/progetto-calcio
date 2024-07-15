package com.calcio.gestioneClassifiche.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestioneClassifiche.entity.ClassificaEntity;

@Repository
public interface ClassificaRepository extends JpaRepository<ClassificaEntity, Long> {
	
	@Query(value = "SELECT * FROM classifica WHERE nazione = ?", nativeQuery = true)
	public List<ClassificaEntity> findPunteggiByNazione(String nazione);

}
