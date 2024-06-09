package com.calcio.gestioneFigureCalcistiche.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestioneFigureCalcistiche.entities.AllenatoreEntity;
import com.calcio.gestioneFigureCalcistiche.messages.EsitoRicerca;
import com.calcio.gestioneFigureCalcistiche.repositories.AllenatoreRepository;

@Service
public class AllenatoreService {
	
	@Autowired
	private AllenatoreRepository allenatoreRepository;
	
	@Autowired
	private EsitoRicerca esitoRicerca;
	
	public List<AllenatoreEntity> getAllAllenatori() {
		
		List<AllenatoreEntity> allenatori = allenatoreRepository.findAll();
		
		if(allenatori.size() > 0) {
			
			System.out.println("Allenatori trovati: "+ allenatori);
		} else {
			
			System.out.println("Nessun allenatore trovato");
		}
		
		return allenatori;
	}
	
	public AllenatoreEntity getAllenatore(Long id) {
		
		AllenatoreEntity allenatore = allenatoreRepository.findById(id).get();
		
		if(allenatore != null) {
			
			System.out.println("Allenatore trovato: "+ allenatore);
		} else {
			
			System.out.println("Nessun allenatore trovato");
		}
		
		return allenatore;
	}
	
	public AllenatoreEntity insertAllenatore(AllenatoreEntity allenatoreEntity) {
		
		AllenatoreEntity allenatore = allenatoreRepository.save(allenatoreEntity);
		
		if(allenatore != null) {
			
			System.out.println("Allenato aggiunto: "+ allenatore);
		} else {
			
			System.out.println("Nessun allenatore da inserire");
		}
		
		return allenatore;
	}
	
	public AllenatoreEntity updateAllenatore(Long id, AllenatoreEntity allenatoreEntity) {
		
		AllenatoreEntity allenatore = allenatoreRepository.findById(id).get();
		AllenatoreEntity updatedAllenatore = null;
		
		if(allenatore != null) {
			
			allenatore.setNome(allenatoreEntity.getNome());
			allenatore.setCognome(allenatoreEntity.getCognome());
			allenatore.setAltezza(allenatoreEntity.getAltezza());
			allenatore.setEta(allenatoreEntity.getEta());
			allenatore.setNazionalita(allenatoreEntity.getNazionalita());
			allenatore.setPeso(allenatoreEntity.getPeso());
			allenatore.setIdSquadra(allenatoreEntity.getIdSquadra());
			allenatore.setDataModifica(LocalDateTime.now());
			
			updatedAllenatore = allenatoreRepository.save(allenatore);
			
			System.out.println("Allenatore aggiornato: "+ updatedAllenatore);
		} else {
			
			System.out.println("Allenatore non aggiornato");
		}
		
		return allenatore;
	}
	
	public void deleteAllenatore(Long id) {
		
		allenatoreRepository.deleteById(id);
		
		System.out.println("Allenatore eliminato");
	}
	
	public AllenatoreEntity getAllenatoreBySquadra(Long squadra) {
		
		AllenatoreEntity allenatore = allenatoreRepository.findAllenatoreBySquadra(squadra);
		
		if(allenatore != null) {
			
			System.out.println("Allenatore della squadra trovato: "+ allenatore);
		} else {
			
			System.out.println("Nessun allenatore trovato");
		}
		
		return allenatore;
	}
	
	public EsitoRicerca getInfoEsitoRicercaAllenatore(List<AllenatoreEntity> allenatori) {
		
		if (allenatori != null) {

			if (allenatori.size() == 0) {

				esitoRicerca.setCodiceEsito("EA01");
				esitoRicerca.setDescrizioneEsito("Errore: nessun allenatore trovato");
			} else {

			esitoRicerca.setCodiceEsito("AA01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("EA02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}

}
