package com.calcio.gestionePartite.services;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestionePartite.entities.PartitaEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.repositories.PartitaRepository;

@Service
public class PartitaService {
	
	@Autowired
	private PartitaRepository partitaRepository;
	
	@Autowired
	private EsitoRicerca esitoRicerca;
	
	public List<PartitaEntity> findAllPartite() {
		
		List<PartitaEntity> partite = partitaRepository.findAll();
		
		if(partite.size() > 0) {
			
			System.out.println("Partite trovate: "+ partite);
		} else {
			
			System.out.println("Partite non trovate");
		}
		
		return partite;
	}
	
	public PartitaEntity findPartitaById(Long id) {
		
		PartitaEntity partita = partitaRepository.findById(id).get();
		
		if(partita != null) {
			
			System.out.println("Partita trovata: "+ partita);
		} else {
			
			System.out.println("Partita non trovata");
		}
		
		return partita;
	}
	
	public PartitaEntity inserPartita(PartitaEntity partitaEntity) {
		
		PartitaEntity partita = partitaRepository.save(partitaEntity);
		
		if(partita != null) {
			
			System.out.println("Partita aggiunta" + partita);
		} else {
			
			System.out.println("Nessuna partita aggiunta");
		}
		
		return partita;
	}
	
	public PartitaEntity updatePartita(PartitaEntity partitaEntity, Long id) {
		
		PartitaEntity partita = partitaRepository.findById(id).get();
		PartitaEntity updatedPartita = null;
		
		if(partita != null) {
			
			partita.setSquadraCasa(partitaEntity.getSquadraCasa());
			partita.setRisultatoPartita(partitaEntity.getRisultatoPartita());
			partita.setSquadraOspite(partitaEntity.getSquadraOspite());
			partita.setIdGiornata(partitaEntity.getIdGiornata());
			partita.setDataPartita(partita.getDataPartita());
			
			updatedPartita = partitaRepository.save(partita);
			
			System.out.println("Partita aggiornata: "+ updatedPartita);
		} else {
			
			System.out.println("Partita non aggiornata");
		}
		
		return updatedPartita;
	}
	
	public void deletePartita(Long id) {
		
		partitaRepository.deleteById(id);
	}
	
	public EsitoRicerca getInfoEsitoRicercaPartita(List<PartitaEntity> partite) {
		
		if (partite != null) {

			if (partite.size() == 0) {

				esitoRicerca.setCodiceEsito("EP01");
				esitoRicerca.setDescrizioneEsito("Errore: nessuna partita trovata");
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
	
	public List<PartitaEntity> findMatchDay() {
		
		List<PartitaEntity> partite = partitaRepository.findMatchDay();
		
		if( partite.size() > 0) {
			
			System.out.println("Partite di oggi trovate: "+ partite);
		} else {
			
			System.out.println("Oggi non c'è nessuna partita!");
		}
		
		return partite;
	}
	
	public List<PartitaEntity> findMatchYesterday() {
		
		List<PartitaEntity> partite = partitaRepository.findMatchYesterday();
		
		if( partite.size() > 0) {
			
			System.out.println("Partite di ieri trovate: "+ partite);
		} else {
			
			System.out.println("Ieri non c'è stata nessuna partita!");
		}
		
		return partite;
	}
	
	public List<PartitaEntity> findMatchTomorrow() {
		
		List<PartitaEntity> partite = partitaRepository.findMatchTomorrow();
		
		if( partite.size() > 0) {
			
			System.out.println("Partite di domani trovate: "+ partite);
		} else {
			
			System.out.println("Domani non ci sarà nessuna partita!");
		}
		
		return partite;
	}
	
	public List<PartitaEntity> findMatchByGiornata(Integer idGiornata, Integer idCampionato) {
		
		List<PartitaEntity> partite = partitaRepository.findMatchByGiornata(idGiornata, idCampionato);
		
		if( partite.size() > 0) {
			
			System.out.println("Partite della giornata: "+ idGiornata+ " trovate: "+ partite);
		} else {
			
			System.out.println("Nessuna partita trovata della giornata: "+ idGiornata);
		}
		
		return partite;
	}
	
	public List<PartitaEntity> findLastFiveMatchBySquadra(String nomeSquadra) {
		
		List<PartitaEntity> allPartite = partitaRepository.findMatchBySquadra(nomeSquadra, nomeSquadra);
		
		List<PartitaEntity> partite = allPartite.subList(Math.max(allPartite.size() - 15, 0), allPartite.size());
		
		if(partite.size() > 0) {
			
			System.out.println("Ultime partite trovate: "+partite);
		} else {
			
			System.out.println("Nessuna partita trovata");
		}
		
		return partite;
	}
	
	public List<PartitaEntity> findRecentMatch(Integer idCampionato) {
		
		LocalDateTime oggi = LocalDateTime.now();
		boolean trovata = false;
		int MAX_DAYS_BACK = 30;
		List<PartitaEntity> partiteEntity = new ArrayList<>();
		
		List<PartitaEntity> partite = partitaRepository.findAll();
		System.out.println(partite);
		Collections.reverse(partite);
		System.out.println(partite);		
		while(!trovata && MAX_DAYS_BACK > 0) {
			
			System.out.println("sono dentro al while");
			for (PartitaEntity partita: partite) {
				
				System.out.println("sono dentro al for");
				
				if(partita.getDataPartita().toLocalDate().isEqual(oggi.toLocalDate())) {
					
					System.out.println("sono dentro all'if");
					System.out.println(oggi.toLocalDate());
					
					Integer giornata = partitaRepository.recuperoGiornata(oggi.toLocalDate());
					
					System.out.println(giornata);
					
					partiteEntity = partitaRepository.findMatchByGiornata(giornata, idCampionato);
					
					System.out.println(partiteEntity);
					
					trovata = true;
					break;
				} else {
				
					oggi = oggi.minusDays(1);
					MAX_DAYS_BACK--;
				}
				
				break;
			}
		}
		
		System.out.println(partiteEntity);
		
		return partiteEntity;
	}


	
}
