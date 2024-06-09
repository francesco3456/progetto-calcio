package com.calcio.gestioneClassifiche.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestioneClassifiche.entity.ClassificaEntity;
import com.calcio.gestioneClassifiche.messages.EsitoRicerca;
import com.calcio.gestioneClassifiche.repository.ClassificaRepository;

@Service
public class ClassificaService {
	
	@Autowired
	EsitoRicerca esitoRicerca;
	
	@Autowired
	ClassificaRepository classificaRepository;
	
	public List<ClassificaEntity> findAllPunteggi() {
		
		List<ClassificaEntity> punteggi = classificaRepository.findAll();
		
		if(punteggi.size() > 0) {
			
			System.out.println("I punteggi delle classifica sono stati trovati: "+ punteggi);
		} else {
			
			System.out.println("Nessun punteggio trovato");
		}
		
		return punteggi;
	}
	
	public ClassificaEntity findPunteggioById(Long idPunteggio) {
		
		ClassificaEntity punteggio = classificaRepository.findById(idPunteggio).get();
		
		if(punteggio != null) {
			
			System.out.println("Il seguente punteggio non è stato trovato: "+ punteggio);
		} else {
			
			System.out.println("Nessun punteggio corrispondente alla richiesta");
		}
		
		return punteggio;
	}
	
	public ClassificaEntity insertPunteggio(ClassificaEntity punteggio) {
		
		ClassificaEntity result = classificaRepository.save(punteggio);
		
		if(result != null) {
			
			System.out.println("Punteggio inserito correttamente: "+ result);
		} else {
			
			System.out.println("Il seguente punteggio non è stato inserito");
		}
		
		return result;
	}
	
	public ClassificaEntity updatePunteggio(Long idPunteggio, ClassificaEntity classificaEntity) {
		
		ClassificaEntity punteggio = classificaRepository.findById(idPunteggio).get();
		ClassificaEntity updatedPunteggio = null;
		
		if(punteggio != null) {
			
			punteggio.setCodiceSquadra(classificaEntity.getCodiceSquadra());
			punteggio.setPuntiSquadra(classificaEntity.getPuntiSquadra());
			punteggio.setVittorieSquadra(classificaEntity.getVittorieSquadra());
			punteggio.setPareggiSquadra(classificaEntity.getPareggiSquadra());
			punteggio.setSconfitteSquadra(classificaEntity.getSconfitteSquadra());
			punteggio.setGolFattiSquadra(classificaEntity.getGolFattiSquadra());
			punteggio.setGolSubitiSquadra(classificaEntity.getGolSubitiSquadra());
			punteggio.setDifferenzaRetiSquadra(classificaEntity.getDifferenzaRetiSquadra());
			punteggio.setDataModifica(LocalDateTime.now());
			
			updatedPunteggio = classificaRepository.save(punteggio);
			
			System.out.println("Punteggio aggiornato con successo: "+ updatedPunteggio);
		} else {
			
			System.out.println("Non è stato possibile aggiornare il punteggio");
		}
		
		return updatedPunteggio;
	}
	
	public void deletePunteggio(Long idPunteggio) {
		
		classificaRepository.deleteById(idPunteggio);
		
		System.out.println("Punteggio eliminato");
	}
	
	public EsitoRicerca getInfoEsitoRicercaClassifica(List<ClassificaEntity> punteggi) {
		
		if (punteggi != null) {

			if (punteggi.size() == 0) {

				esitoRicerca.setCodiceEsito("EP01");
				esitoRicerca.setDescrizioneEsito("Errore: nessun punteggio trovato");
			} else {

			esitoRicerca.setCodiceEsito("AP01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("EP02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}
	
	public List<ClassificaEntity> findPunteggiByNazione(String nazione) {
		
		List<ClassificaEntity> punteggi = classificaRepository.findPunteggiByNazione(nazione);
		
		if(punteggi != null) {
			System.out.println("Punteggi trovati: "+ punteggi + "per la seguente nazione: "+ nazione);
		} else {
			System.out.println("Nessun punteggio è stato trovato");
		}
		
		return punteggi;
	}

}
