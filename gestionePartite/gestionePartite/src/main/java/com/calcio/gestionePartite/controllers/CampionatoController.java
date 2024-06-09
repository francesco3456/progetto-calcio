package com.calcio.gestionePartite.controllers;

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

import com.calcio.gestionePartite.entities.CampionatoEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.messages.RicercaResponseCampionato;
import com.calcio.gestionePartite.services.CampionatoService;

@RestController
@RequestMapping("/campionati")
public class CampionatoController {
	
	@Autowired
	private CampionatoService campionatoService;
	
	@Autowired
	private RicercaResponseCampionato ricercaResponse;
	
	@GetMapping
	public RicercaResponseCampionato getAllCampionati() {
		
		List<CampionatoEntity> campionati = campionatoService.findAllCampionati();
		EsitoRicerca esitoRicerca = campionatoService.getInfoEsitoRicercaCampionato(campionati);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCampionati(campionati);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{id}")
	public RicercaResponseCampionato getCampionatoById(@PathVariable Long id) {
		
		CampionatoEntity campionato = campionatoService.findCampionatoById(id);
		List<CampionatoEntity> result = new ArrayList<>();
		
		result.add(campionato);
		
		EsitoRicerca esitoRicerca = campionatoService.getInfoEsitoRicercaCampionato(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCampionati(result);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseCampionato insertCampionato(@RequestBody CampionatoEntity campionatoEntity) {
		
		CampionatoEntity campionato = campionatoService.insertCampionato(campionatoEntity);
		List<CampionatoEntity> result = new ArrayList<>();
		
		result.add(campionato);
		
		EsitoRicerca esitoRicerca = campionatoService.getInfoEsitoRicercaCampionato(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCampionati(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("/{id}")
	public RicercaResponseCampionato updateCampionato(@RequestBody CampionatoEntity campionatoEntity, @PathVariable Long id) {
		
		CampionatoEntity campionato = campionatoService.updateCampionato(campionatoEntity, id);
		List<CampionatoEntity> result = new ArrayList<>();
		
		result.add(campionato);
		
		EsitoRicerca esitoRicerca = campionatoService.getInfoEsitoRicercaCampionato(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCampionati(result);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCampionato(@PathVariable Long id) {
		
		campionatoService.deleteCampionato(id);
	}
	
	@GetMapping("/nomi-campionati")
	public RicercaResponseCampionato findAllNomiCampionato() {
		
		List<String> nomi = campionatoService.findAllNomiCampionato();
		List<Object> result = new ArrayList<>();
		
		result.add(nomi);
		
		EsitoRicerca esitoRicerca = campionatoService.getInfoEsitoRicercaCampionatoForObject(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setAltraListaCampionati(result);
		
		return ricercaResponse;
	}

}
