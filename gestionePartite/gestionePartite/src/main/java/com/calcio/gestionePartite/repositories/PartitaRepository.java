package com.calcio.gestionePartite.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calcio.gestionePartite.entities.PartitaEntity;

@Repository
public interface PartitaRepository extends JpaRepository<PartitaEntity, Long> {
	
	@Query(value = "SELECT * FROM partita WHERE DATE(data_partita) = CURDATE()", nativeQuery = true)
	public List<PartitaEntity> findMatchDay();
	
	@Query(value = "SELECT * FROM partita WHERE DATE(data_partita) = CURDATE() + INTERVAL 1 DAY", nativeQuery = true)
	public List<PartitaEntity> findMatchTomorrow();
	
	@Query(value = "SELECT * FROM partita WHERE DATE(data_partita) = CURDATE() - INTERVAL 1 DAY", nativeQuery = true)
	public List<PartitaEntity> findMatchYesterday();
	
	@Query(value = "SELECT * FROM partita WHERE id_giornata = ? AND id_campionato = ?", nativeQuery = true)
	public List<PartitaEntity> findMatchByGiornata(Integer idGiornata, Integer idCampionato);
	
	@Query(value = "SELECT id_giornata FROM partita WHERE DATE(data_partita) = ?", nativeQuery = true)
	public Integer recuperoGiornata(LocalDate dataPartita);
	
	@Query(value = "SELECT * FROM partita WHERE squadra_casa = ? OR squadra_ospite = ?", nativeQuery = true)
	public List<PartitaEntity> findMatchBySquadra(String squadraCasa, String squadraOspite);
	
}
