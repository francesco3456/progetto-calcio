package com.calcio.gestioneClassifiche.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcio.gestioneClassifiche.entity.StatsCalciatoreEntity;
import com.calcio.gestioneClassifiche.messages.EsitoRicerca;
import com.calcio.gestioneClassifiche.messages.RicercaResponseStatsCalciatore;
import com.calcio.gestioneClassifiche.services.StatsCalciatoreService;

@RestController
@RequestMapping("/stats-calciatori")
public class StatsCalciatoreController {
	
	@Autowired
	RicercaResponseStatsCalciatore ricercaResponse;
	
	@Autowired
	StatsCalciatoreService statsCalciatoreService;
	
	@GetMapping
	public RicercaResponseStatsCalciatore getAllStatsCalciatori() {
		
		List<StatsCalciatoreEntity> statsCalciatori = statsCalciatoreService.findAllStatsCalciatori();
		EsitoRicerca esitoRicerca = statsCalciatoreService.getInfoEsitoRicercaStatsCalciatori(statsCalciatori);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaStatsCalciatori(statsCalciatori);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{idStats}")
	public RicercaResponseStatsCalciatore getStatsCalciatore(@PathVariable Long idStats) {
		
		StatsCalciatoreEntity statsCalciatore = statsCalciatoreService.findStatsById(idStats);
		List<StatsCalciatoreEntity> result = new ArrayList<>();
		
		result.add(statsCalciatore);
		
		EsitoRicerca esitoRicerca = statsCalciatoreService.getInfoEsitoRicercaStatsCalciatori(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaStatsCalciatori(result);
		
		return ricercaResponse;
	}
	
	@GetMapping("/calciatori/{codiceSquadra}")
	public RicercaResponseStatsCalciatore getStatsCalciatoreBySquadra(@PathVariable String codiceSquadra) {
		
		List<StatsCalciatoreEntity> statsCalciatore = statsCalciatoreService.findStatsBySquadra(codiceSquadra);		
		
		EsitoRicerca esitoRicerca = statsCalciatoreService.getInfoEsitoRicercaStatsCalciatori(statsCalciatore);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaStatsCalciatori(statsCalciatore);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseStatsCalciatore insertStatsCalciatore(@RequestBody StatsCalciatoreEntity statsCalciatore) {
		
		StatsCalciatoreEntity statsCalciatoreEntity = statsCalciatoreService.insertStatsCalciatore(statsCalciatore);
		List<StatsCalciatoreEntity> result = new ArrayList<>();
		
		result.add(statsCalciatoreEntity);
		
		EsitoRicerca esitoRicerca = statsCalciatoreService.getInfoEsitoRicercaStatsCalciatori(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaStatsCalciatori(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("/{id}")
	public RicercaResponseStatsCalciatore updateStatsCalciatore(@RequestBody StatsCalciatoreEntity statsCalciatore, @PathVariable Long id) {
		
		StatsCalciatoreEntity statsCalciatoreEntity = statsCalciatoreService.updateStatsCalciatore(statsCalciatore, id);
		List<StatsCalciatoreEntity> result = new ArrayList<>();
		
		result.add(statsCalciatoreEntity);
		
		EsitoRicerca esitoRicerca = statsCalciatoreService.getInfoEsitoRicercaStatsCalciatori(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaStatsCalciatori(result);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("/{idStats}")
	public void deleteStatsCalciatore(@PathVariable Long idStats) {
		
		statsCalciatoreService.deleteStatsCalciatore(idStats);
	}

}
