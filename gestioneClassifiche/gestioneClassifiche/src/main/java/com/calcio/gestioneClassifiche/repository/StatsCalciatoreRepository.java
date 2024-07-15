package com.calcio.gestioneClassifiche.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestioneClassifiche.entity.StatsCalciatoreEntity;

@Repository
public interface StatsCalciatoreRepository extends JpaRepository<StatsCalciatoreEntity, Long> {
	
	@Query(value = "SELECT * FROM stats_calciatore WHERE nazione = ?", nativeQuery = true)
	public List<StatsCalciatoreEntity> findStatsByNazione(String nazione);
	
	@Query(value = "SELECT * FROM stats_calciatore WHERE cod_squadra = ?", nativeQuery = true)
	public List<StatsCalciatoreEntity> findStatsBySquadra(String codiceSquadra);

}
