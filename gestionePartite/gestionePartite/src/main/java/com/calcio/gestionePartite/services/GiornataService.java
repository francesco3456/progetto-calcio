package com.calcio.gestionePartite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestionePartite.entities.GiornataEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.repositories.GiornataRepository;

@Service
public class GiornataService {
	
	@Autowired
	private GiornataRepository giornataRepository;
	
	@Autowired
	private EsitoRicerca esitoRicerca;
	
	public List<GiornataEntity> findAllGiornate() {
		
		List<GiornataEntity> giornate = giornataRepository.findAll();
		
		if(giornate.size() > 0) {
			
			System.out.println("Giornate trovate: "+giornate);
		} else {
			
			System.out.println("Giornata non trovata");
		}
		
		return giornate;
	}
	
	public GiornataEntity findGiornataById(Long id) {
		
		GiornataEntity giornata = giornataRepository.findById(id).get();
		
		if(giornata != null) {
			
			System.out.println("Giornata trovata: "+giornata);
		} else {
			
			System.out.println("Giornata non trovata");
		}
		
		return giornata;
	}
	
	public GiornataEntity insertGiornata(GiornataEntity giornataEntity) {
		
		GiornataEntity giornata = giornataRepository.save(giornataEntity);
		
		if(giornata != null) {
			
			System.out.println("Giornata aggiunta: "+giornata);
		} else {
			
			System.out.println("Nessuna giornata da inserire");
		}
		
		return giornata;
	}
	
	public GiornataEntity updateGiornata(GiornataEntity giornataEntity, Long id) {
		
		GiornataEntity giornata = giornataRepository.findById(id).get();
		GiornataEntity updatedGiornata = null;
		
		if(giornata != null) {
			
			giornata.setInizioGiornata(giornataEntity.getInizioGiornata());
			giornata.setFineGiornata(giornataEntity.getFineGiornata());
			giornata.setNumGiornata(giornataEntity.getNumGiornata());
			
			updatedGiornata = giornataRepository.save(giornata);
			
			System.out.println("Giornata aggiornata: "+updatedGiornata);
		} else {
			
			System.out.println("Giornata non aggiornata");
		}
		
		return updatedGiornata;
	}
	
	public void deleteGiornata(Long id) {
		
		giornataRepository.deleteById(id);
	}
	
	public EsitoRicerca getInfoEsitoRicercaGiornata(List<GiornataEntity> giornate) {
		
		if (giornate != null) {

			if (giornate.size() == 0) {

				esitoRicerca.setCodiceEsito("EG01");
				esitoRicerca.setDescrizioneEsito("Errore: nessuna giornata trovata");
			} else {

			esitoRicerca.setCodiceEsito("AG01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("EG02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}
	
	public EsitoRicerca getInfoEsitoRicercaGiornataForObject(List<Object> giornate) {
		
		if (giornate != null) {

			if (giornate.size() == 0) {

				esitoRicerca.setCodiceEsito("EG01");
				esitoRicerca.setDescrizioneEsito("Errore: nessuna giornata trovata");
			} else {

			esitoRicerca.setCodiceEsito("AG01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("EG02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}
	
	public List<Integer> findAllNumGiornate() {
		
		List<Integer> numGiornate = giornataRepository.findAllNumGiornate();
		
		if(numGiornate.size() > 0) {
			
			System.out.println("Numeri delle giornate trovate: "+ numGiornate);
		} else {
			
			System.out.println("Nessun numero delle giornate trovato");
		}
		
		return numGiornate;
	}

}
