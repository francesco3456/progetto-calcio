package com.calcio.gestioneClassifiche.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calcio.gestioneClassifiche.entity.StatsCalciatoreEntity;
import com.calcio.gestioneClassifiche.messages.EsitoRicerca;
import com.calcio.gestioneClassifiche.repository.StatsCalciatoreRepository;

@Service
public class StatsCalciatoreService {
	
	@Autowired
	EsitoRicerca esitoRicerca;
	
	@Autowired
	StatsCalciatoreRepository statsCalciatoreRepository;
	
	public List<StatsCalciatoreEntity> findAllStatsCalciatori() {
		
		List<StatsCalciatoreEntity> statsCalciatori = statsCalciatoreRepository.findAll();
		
		if(statsCalciatori.size() > 0) {
			
			System.out.println("Stats dei calciatori trovate: "+ statsCalciatori);
		} else {
			
			System.out.println("Nessuna stats trovata");
		}
		
		return statsCalciatori;
	}
	
	public StatsCalciatoreEntity findStatsById(Long idStatsCalciatore) {
		
		StatsCalciatoreEntity statsCalciatore = statsCalciatoreRepository.findById(idStatsCalciatore).get();
		
		if(statsCalciatore != null) {
			
			System.out.println("Stats del calciatore trovate: "+ statsCalciatore);
		} else {
			
			System.out.println("Nessuna stats trovata");
		}
		
		return statsCalciatore;
	}
	
	public StatsCalciatoreEntity insertStatsCalciatore(StatsCalciatoreEntity statsCalciatore) {
		
		StatsCalciatoreEntity result = statsCalciatoreRepository.save(statsCalciatore);
		
		if(result != null) {
			
			System.out.println("Stats del calciatore inserite correttamente");
		} else {
			
			System.out.println("Inserimento non eseguito correttamente");
		}
		
		return result;
	}
	
	public StatsCalciatoreEntity updateStatsCalciatore(StatsCalciatoreEntity statsCalciatoreEntity, Long idStatsCalciatore) {
		
		StatsCalciatoreEntity statsCalciatore = statsCalciatoreRepository.findById(idStatsCalciatore).get();
		StatsCalciatoreEntity updatedStatsCalciatore = null;
		
		if(statsCalciatore != null) {
			
			statsCalciatore.setCalciatore(statsCalciatoreEntity.getCalciatore());
			statsCalciatore.setGolCalciatore(statsCalciatoreEntity.getGolCalciatore());
			statsCalciatore.setAssistCalciatore(statsCalciatoreEntity.getAssistCalciatore());
			statsCalciatore.setNumAmmonizioni(statsCalciatoreEntity.getNumAmmonizioni());
			statsCalciatore.setNumEspulsioni(statsCalciatoreEntity.getNumEspulsioni());
			statsCalciatore.setDataModifica(LocalDateTime.now());
			
			updatedStatsCalciatore = statsCalciatoreRepository.save(statsCalciatore);
			
			System.out.println("Stats del calciatore aggiornate con successo: "+ updatedStatsCalciatore);
		} else {
			
			System.out.println("Stats del calciatore non sono state aggiornate");
		}
		
		return updatedStatsCalciatore;
	}
	
	public void deleteStatsCalciatore(Long idStatsCalciatore) {
		
		statsCalciatoreRepository.deleteById(idStatsCalciatore);
		
		System.out.println("Stats del calciatore eliminate");
	}
	
	public EsitoRicerca getInfoEsitoRicercaStatsCalciatori(List<StatsCalciatoreEntity> statsCalciatori) {
		
		if (statsCalciatori != null) {

			if (statsCalciatori.size() == 0) {

				esitoRicerca.setCodiceEsito("ESC01");
				esitoRicerca.setDescrizioneEsito("Errore: nessuna stats trovata");
			} else {

			esitoRicerca.setCodiceEsito("ASC01");
			esitoRicerca.setDescrizioneEsito("Ricerca eseguita con successo");
			
			}

		} else {

			esitoRicerca.setCodiceEsito("ESC02");
			esitoRicerca.setDescrizioneEsito("C'è stato un errore");

		}
		
		return esitoRicerca;
		
	}
	
	public List<StatsCalciatoreEntity> findStatsByNazione(String nazione) {
		
		List<StatsCalciatoreEntity> stats = statsCalciatoreRepository.findStatsByNazione(nazione);
		
		if(stats != null) {
			System.out.println("Stats trovate: "+ stats + "per la seguente nazione: "+ nazione);
		} else {
			System.out.println("Nessuna stats trovata");
		}
		
		return stats;
	}
	
	public List<StatsCalciatoreEntity> findStatsBySquadra(String codiceSquadra) {
		
		List<StatsCalciatoreEntity> stats = statsCalciatoreRepository.findStatsBySquadra(codiceSquadra);
		
		if(stats != null) {
			System.out.println("Stats trovate: "+ stats + "per la seguente squadra: "+ codiceSquadra);
		} else {
			System.out.println("Nessuna stats trovata");
		}
		
		return stats;
	}

}
