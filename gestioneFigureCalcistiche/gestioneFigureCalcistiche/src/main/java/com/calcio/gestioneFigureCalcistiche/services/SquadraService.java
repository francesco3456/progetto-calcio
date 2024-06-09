package com.calcio.gestioneFigureCalcistiche.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestioneFigureCalcistiche.entities.SquadraEntity;
import com.calcio.gestioneFigureCalcistiche.messages.EsitoRicerca;
import com.calcio.gestioneFigureCalcistiche.repositories.SquadraRepository;

@Service
public class SquadraService {
	
	@Autowired
	private SquadraRepository squadraRepository;
	
	@Autowired
	private EsitoRicerca esitoRicerca;
	
	public List<SquadraEntity> getAllSquadre() {
		
		List<SquadraEntity> squadre = squadraRepository.findAll();
		
		if(squadre.size() > 0) {
			
			System.out.println("Squadre trovate: "+ squadre);
			
		} else {
			
			System.out.println("Nessuna squadra trovata");
		}
		
		return squadre;
	}
	
	public SquadraEntity getSquadra(Long id) {
		
		SquadraEntity squadra = squadraRepository.findById(id).get();
		
		if(squadra != null) {
			
			System.out.println("Squadra trovata: "+ squadra);
		} else {
			
			System.out.println("Squadra non trovata");
		}
		
		return squadra;
	}
	
	public SquadraEntity getNomeSquadra(String nome) {
		
		SquadraEntity squadra = squadraRepository.findNomeSquadra(nome);
		
		if(squadra != null) {
			
			System.out.println("Squadra trovata: "+ squadra);
		} else {
			
			System.out.println("Squadra non trovata");
		}
		
		return squadra;
	}
	
	public SquadraEntity insertSquadra(SquadraEntity squadraEntity) {
		
		SquadraEntity squadra = squadraRepository.save(squadraEntity);
		
		if(squadra != null) {
			
			System.out.println("Squadra da inserire: "+ squadra);
		} else {
			
			System.out.println("Nessuna squadra da inserire");
		}
		
		return squadra;
	}
	
	public SquadraEntity updateSquadra(Long id, SquadraEntity squadraEntity) {
		
		SquadraEntity squadra = squadraRepository.findById(id).get();
		SquadraEntity updatedSquadra = null;
		
		if(squadra != null) {
			
			squadra.setNomeSquadra(squadraEntity.getNomeSquadra());
			squadra.setNazionalitaSquadra(squadraEntity.getNazionalitaSquadra());
			squadra.setCittaSquadra(squadraEntity.getCittaSquadra());
			squadra.setNascitaSquadra(squadraEntity.getNascitaSquadra());
			squadra.setStadioSquadra(squadraEntity.getStadioSquadra());
			squadra.setStemma(squadraEntity.getStemma());
			squadra.setDataModifica(LocalDateTime.now());
			
			updatedSquadra = squadraRepository.save(squadra);
			
			System.out.println("squadra aggiornata: "+ updatedSquadra);
		} else {
			
			System.out.println("Squadra non aggiornata");
		}
		
		return updatedSquadra;
	}
	
	public void deleteSquadra(Long id) {
		
		squadraRepository.deleteById(id);
		
		System.out.println("Squadra eliminata");
	}
	
	public EsitoRicerca getInfoEsitoRicercaSquadra(List<SquadraEntity> squadre) {
		
		if (squadre != null) {

			if (squadre.size() == 0) {

				esitoRicerca.setCodiceEsito("ES01");
				esitoRicerca.setDescrizioneEsito("Errore: nessuna squadra trovata");
			} else {

			esitoRicerca.setCodiceEsito("AS01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("ES02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}

}
