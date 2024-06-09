package com.calcio.gestionePartite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestionePartite.entities.CampionatoEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.repositories.CampionatoRepository;

@Service
public class CampionatoService {
	
	@Autowired
	private CampionatoRepository campionatoRepository;
	
	@Autowired
	private EsitoRicerca esitoRicerca;
	
	public List<CampionatoEntity> findAllCampionati() {
		
		List<CampionatoEntity> campionati = campionatoRepository.findAll();
		
		if(campionati.size() > 0) {
			
			System.out.println("Campionati trovati: "+campionati);
		} else {
			
			System.out.println("Nessun campionato trovato");
		}
		
		return campionati;
	}
	
	public CampionatoEntity findCampionatoById(Long id) {
		
		CampionatoEntity campionato = campionatoRepository.findById(id).get();
		
		if(campionato != null) {
			
			System.out.println("Campionato trovato: "+ campionato);
		} else {
			
			System.out.println("Campionato non trovato");
		}
		
		return campionato;
	}
	
	public CampionatoEntity insertCampionato(CampionatoEntity campionatoEntity) {
		
		CampionatoEntity campionato = campionatoRepository.save(campionatoEntity);
		
		if(campionato != null) {
			
			System.out.println("Campionato aggiunto: "+campionato);
		} else {
			
			System.out.println("Campionato non aggiunto");
		}
		
		return campionato;
	}
	
	public CampionatoEntity updateCampionato(CampionatoEntity campionatoEntity, Long id) {
		
		CampionatoEntity campionato = campionatoRepository.findById(id).get();
		CampionatoEntity updatedCampionato = null;
		
		if(campionato != null) {
			
			campionato.setNomeCampionato(campionatoEntity.getNomeCampionato());
			campionato.setInizioCampionato(campionatoEntity.getInizioCampionato());
			campionato.setFineCampionato(campionatoEntity.getFineCampionato());
			campionato.setStagioneCampionato(campionatoEntity.getStagioneCampionato());
			campionato.setBandieraCampionato(campionatoEntity.getBandieraCampionato());
			
			updatedCampionato = campionatoRepository.save(campionato);
			
			System.out.println("Campionato aggiornato");
		} else {
			
			System.out.println("Nessun campionato aggiornato");
		}
		
		return updatedCampionato;
	}
	
	public void deleteCampionato(Long id) {
		
		campionatoRepository.deleteById(id);
	}
	
	public EsitoRicerca getInfoEsitoRicercaCampionato(List<CampionatoEntity> campionati) {
		
		if (campionati != null) {

			if (campionati.size() == 0) {

				esitoRicerca.setCodiceEsito("ECA01");
				esitoRicerca.setDescrizioneEsito("Errore: nessun campionato trovato");
			} else {

			esitoRicerca.setCodiceEsito("ACA01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("ECA02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}
	
	public EsitoRicerca getInfoEsitoRicercaCampionatoForObject(List<Object> campionati) {
		
		if (campionati != null) {

			if (campionati.size() == 0) {

				esitoRicerca.setCodiceEsito("ECA01");
				esitoRicerca.setDescrizioneEsito("Errore: nessun campionato trovato");
			} else {

			esitoRicerca.setCodiceEsito("ACA01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("ECA02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}
	
	public List<String> findAllNomiCampionato() {
		
		List<String> nomi = campionatoRepository.findAllNomiCampionato();
		
		if(nomi.size() > 0) {
			
			System.out.println("Nomi dei campionati trovati: "+ nomi);
		} else {
			
			System.out.println("Nessun nome dei campionati trovato");
		}
		
		return nomi;
	}

}
