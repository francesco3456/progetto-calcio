package com.calcio.gestioneFigureCalcistiche.controllers;

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

import com.calcio.gestioneFigureCalcistiche.entities.AllenatoreEntity;
import com.calcio.gestioneFigureCalcistiche.messages.EsitoRicerca;
import com.calcio.gestioneFigureCalcistiche.messages.RicercaResponseAllenatore;
import com.calcio.gestioneFigureCalcistiche.services.AllenatoreService;

@RestController
@RequestMapping("/allenatori")
public class AllenatoreController {
	
	@Autowired
	private AllenatoreService allenatoreService;
	
	@Autowired
	private RicercaResponseAllenatore ricercaResponse;
	
	@GetMapping
	public RicercaResponseAllenatore getAllAllenatori() {
		
		List<AllenatoreEntity> allenatori = allenatoreService.getAllAllenatori();
		EsitoRicerca esitoRicerca = allenatoreService.getInfoEsitoRicercaAllenatore(allenatori);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaAllenatori(allenatori);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{id}")
	public RicercaResponseAllenatore getAllenatore(@PathVariable Long id) {
		
		AllenatoreEntity allenatore = allenatoreService.getAllenatore(id);
		List<AllenatoreEntity> result = new ArrayList<>();
		
		result.add(allenatore);
		
		EsitoRicerca esitoRicerca = allenatoreService.getInfoEsitoRicercaAllenatore(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaAllenatori(result);
		
		return ricercaResponse;
	}
	
	@GetMapping("/gruppo/{squadra}")
	public RicercaResponseAllenatore getAllenatoreBySquadra(@PathVariable Long squadra) {
		
		AllenatoreEntity allenatore = allenatoreService.getAllenatoreBySquadra(squadra);
		List<AllenatoreEntity> result = new ArrayList<>();
		
		result.add(allenatore);
		
		EsitoRicerca esitoRicerca = allenatoreService.getInfoEsitoRicercaAllenatore(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaAllenatori(result);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseAllenatore insertAllenatore(@RequestBody AllenatoreEntity allenatoreEntity) {
		
		AllenatoreEntity allenatore = allenatoreService.insertAllenatore(allenatoreEntity);
		List<AllenatoreEntity> result = new ArrayList<>();
		
		result.add(allenatore);
		
		EsitoRicerca esitoRicerca = allenatoreService.getInfoEsitoRicercaAllenatore(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaAllenatori(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("/{id}")
	public RicercaResponseAllenatore updateAllenatore(@RequestBody AllenatoreEntity allenatoreEntity, @PathVariable Long id) {
		
		AllenatoreEntity allenatore = allenatoreService.updateAllenatore(id, allenatoreEntity);
		List<AllenatoreEntity> result = new ArrayList<>();
		
		result.add(allenatore);
		
		EsitoRicerca esitoRicerca = allenatoreService.getInfoEsitoRicercaAllenatore(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaAllenatori(result);
		
		return ricercaResponse;
	}

	@DeleteMapping("/{id}")
	public void deleteAllenatore(@PathVariable Long id) {
		
		allenatoreService.deleteAllenatore(id);
	}
	
}
