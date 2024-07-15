package com.calcio.gestioneFigureCalcistiche.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestioneFigureCalcistiche.entities.CalciatoreEntity;
import com.calcio.gestioneFigureCalcistiche.messages.EsitoRicerca;
import com.calcio.gestioneFigureCalcistiche.repositories.CalciatoreRepository;

@Service
public class CalciatoreService {
	
	@Autowired
	private CalciatoreRepository calciatoreRepository;
	
	@Autowired
	private EsitoRicerca esitoRicerca;
	
	
	public List<CalciatoreEntity> getAllCalciatori() {
		
		List<CalciatoreEntity> calciatori = calciatoreRepository.findAll();
		
		if(calciatori.size() > 0) {
			
			System.out.println("Calciatori trovati: "+ calciatori);
		} else {
			
			System.out.println("Calciatori non trovati");
		}
		
		return calciatori;
	}
	
	public CalciatoreEntity getCalciatore(Long id) {
		
		CalciatoreEntity calciatore = calciatoreRepository.findById(id).get();
		
		if(calciatore != null) {
			
			System.out.println("Calciatore trovato: "+ calciatore);
		} else {
			
			System.out.println("Calciatore non trovato: "+ calciatore);
		}
		
		return calciatore;
	}
	
	public CalciatoreEntity insertCalciatore(CalciatoreEntity calciatoreEntity) {
		
		CalciatoreEntity calciatore = calciatoreRepository.save(calciatoreEntity);
		
		if(calciatore != null) {
			
			System.out.println("Calciatore aggiunto: "+ calciatore);
		} else {
			
			System.out.println("Nessun calciatore da inserire");
		}
		
		return calciatore;
	}
	
	public CalciatoreEntity updateCalciatore(CalciatoreEntity calciatoreEntity, Long id) {
		
		CalciatoreEntity calciatore = calciatoreRepository.findById(id).get();
		CalciatoreEntity updatedCalciatore = null;
		
		if(calciatore != null) {
			
			calciatore.setNome(calciatoreEntity.getNome());
			calciatore.setCognome(calciatoreEntity.getCognome());
			calciatore.setAltezza(calciatoreEntity.getAltezza());
			calciatore.setEta(calciatoreEntity.getEta());
			calciatore.setNazionalita(calciatoreEntity.getNazionalita());
			calciatore.setPeso(calciatoreEntity.getPeso());
			calciatore.setRuoloCalciatore(calciatoreEntity.getRuoloCalciatore());
			calciatore.setSquadra(calciatoreEntity.getSquadra());
			calciatore.setCodiceCalciatore(calciatore.getCodiceCalciatore());
			calciatore.setDataModifica(LocalDateTime.now());
			
			updatedCalciatore = calciatoreRepository.save(calciatore);
			
			System.out.println("Calciatore aggiornato: "+ updatedCalciatore);
		} else {
			
			System.out.println("Calciatore non aggiornato");
		}
		
		return calciatoreEntity;
	}
	
	public void deleteCalciatore(Long id) {
		
		calciatoreRepository.deleteById(id);
		
		System.out.println("Calciatore eliminato");
	}
	
	public List<CalciatoreEntity> getCalciatoriBySquadra(Long squadra) {
		
		List<CalciatoreEntity> calciatori = calciatoreRepository.findAllCalciatoriBySquadra(squadra);
		
		if(calciatori != null) {
			
			System.out.println("Calciatori della squadra trovati: "+ calciatori);
		} else {
			
			System.out.println("Nessun calciatore della squadra trovato");
		}
		
		return calciatori;
	}
	
	public EsitoRicerca getInfoEsitoRicercaCalciatore(List<CalciatoreEntity> calciatori) {
		
		if (calciatori != null) {

			if (calciatori.size() == 0) {

				esitoRicerca.setCodiceEsito("EC01");
				esitoRicerca.setDescrizioneEsito("Errore: nessun calciatore trovato");
			} else {

			esitoRicerca.setCodiceEsito("AC01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("EC02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}

}
