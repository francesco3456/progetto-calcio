package com.calcio.gestionePartite.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestionePartite.entities.DettaglioPartitaEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.repositories.DettaglioPartitaRepository;

@Service
public class DettaglioPartitaService {
	
	@Autowired
	private DettaglioPartitaRepository dettaglioRepository;
	
	@Autowired
	private EsitoRicerca esitoRicerca;
	
	public List<DettaglioPartitaEntity> findAllDettagli() {
		
		List<DettaglioPartitaEntity> dettagliPartita = dettaglioRepository.findAll();
		
		if(dettagliPartita.size() > 0) {
			
			System.out.println("Dettagli delle partite trovati: "+dettagliPartita);
		} else {
			
			System.out.println("Nessun dettaglio trovato");
		}
		
		return dettagliPartita;
	}
	
	public DettaglioPartitaEntity findDettagliById(Long id) {
		
		DettaglioPartitaEntity dettaglio = dettaglioRepository.findById(id).get();
		
		if(dettaglio != null) {
			
			System.out.println("Dettaglio trovato: "+ dettaglio);
		} else {
			
			System.out.println("Dettaglio non trovato");
		}
		
		return dettaglio;
	}
	
	public DettaglioPartitaEntity insertDettaglio(DettaglioPartitaEntity dettaglioPartitaEntity) {
		
		DettaglioPartitaEntity dettaglio = dettaglioRepository.save(dettaglioPartitaEntity);
		
		if(dettaglio != null) {
			
			System.out.println("Dettaglio aggiunto: "+dettaglio);
		} else {
			
			System.out.println("Dettaglio non aggiunto");
		}
		
		return dettaglio;
	}
	
	public DettaglioPartitaEntity updateDettaglio(DettaglioPartitaEntity dettaglioPartitaEntity, Long id) {
		
		DettaglioPartitaEntity dettaglio = dettaglioRepository.findById(id).get();
		DettaglioPartitaEntity updatedDettaglio = null;
		
		if(dettaglio != null) {
			
			dettaglio.setEventAmmonizione(dettaglioPartitaEntity.isEventAmmonizione());
			dettaglio.setEventEspulsione(dettaglioPartitaEntity.isEventEspulsione());
			dettaglio.setEventGol(dettaglioPartitaEntity.isEventGol());
			dettaglio.setEventAssist(dettaglioPartitaEntity.isEventAssist());
			dettaglio.setEventMinute(dettaglioPartitaEntity.getEventMinute());
			dettaglio.setCodiceCalciatore(dettaglioPartitaEntity.getCodiceCalciatore());
			dettaglio.setIdPartita(dettaglioPartitaEntity.getIdPartita());
			dettaglio.setDataModifica(LocalDateTime.now());
			
			updatedDettaglio = dettaglioRepository.save(dettaglio);
			
			System.out.println("Dettaglio aggiornato");
		} else {
			
			System.out.println("Nessun dettaglio aggiornato");
		}
		
		return updatedDettaglio;
	}
	
	public void deleteDettaglio(Long id) {
		
		dettaglioRepository.deleteById(id);
	}
	
	public EsitoRicerca getInfoEsitoRicercaDettaglio(List<DettaglioPartitaEntity> dettaglio) {
		
		if (dettaglio != null) {

			if (dettaglio.size() == 0) {

				esitoRicerca.setCodiceEsito("ED01");
				esitoRicerca.setDescrizioneEsito("Errore: nessun dettaglio trovato");
			} else {

			esitoRicerca.setCodiceEsito("AD01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("ED02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}
	
	public EsitoRicerca getInfoEsitoRicercaDettaglioForObject(List<Object> dettagli) {
		
		if (dettagli != null) {

			if (dettagli.size() == 0) {

				esitoRicerca.setCodiceEsito("ED01");
				esitoRicerca.setDescrizioneEsito("Errore: nessun dettaglio trovato");
			} else {

			esitoRicerca.setCodiceEsito("AD01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("ED02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}

}
