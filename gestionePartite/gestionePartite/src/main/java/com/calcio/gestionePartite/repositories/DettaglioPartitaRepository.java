package com.calcio.gestionePartite.repositories;

import org.springframework.stereotype.Repository;

import com.calcio.gestionePartite.entities.DettaglioPartitaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DettaglioPartitaRepository extends JpaRepository<DettaglioPartitaEntity, Long> {

}
