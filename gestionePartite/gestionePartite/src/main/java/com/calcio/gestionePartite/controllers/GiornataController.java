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

import com.calcio.gestionePartite.entities.GiornataEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.messages.RicercaResponseGiornata;
import com.calcio.gestionePartite.services.GiornataService;

@RestController
@RequestMapping("/giornate")
public class GiornataController {
	
	@Autowired
	private GiornataService giornataService;
	
	@Autowired
	private RicercaResponseGiornata ricercaResponse;
	
	@GetMapping
	public RicercaResponseGiornata getAllGiornate() {
		
		List<GiornataEntity> giornate = giornataService.findAllGiornate();
		EsitoRicerca esitoRicerca = giornataService.getInfoEsitoRicercaGiornata(giornate);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaGiornate(giornate);
		
		return ricercaResponse;
	}

	@GetMapping("/{id}")
	public RicercaResponseGiornata getGiornataById(@PathVariable Long id) {
		
		GiornataEntity giornata = giornataService.findGiornataById(id);
		List<GiornataEntity> result = new ArrayList<>();
		
		result.add(giornata);
		
		EsitoRicerca esitoRicerca = giornataService.getInfoEsitoRicercaGiornata(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaGiornate(result);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseGiornata insertGiornata(@RequestBody GiornataEntity giornataEntity) {
		
		GiornataEntity giornata = giornataService.insertGiornata(giornataEntity);
		List<GiornataEntity> result = new ArrayList<>();
		
		result.add(giornata);
		
		EsitoRicerca esitoRicerca = giornataService.getInfoEsitoRicercaGiornata(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaGiornate(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("{id}")
	public RicercaResponseGiornata updateGiornata(@RequestBody GiornataEntity giornataEntity, @PathVariable Long id) {
		
		GiornataEntity giornata = giornataService.updateGiornata(giornataEntity, id);
		List<GiornataEntity> result = new ArrayList<>();
		
		result.add(giornata);
		
		EsitoRicerca esitoRicerca = giornataService.getInfoEsitoRicercaGiornata(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaGiornate(result);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("{id}")
	public void deleteMapping(@PathVariable Long id) {
		
		giornataService.deleteGiornata(id);
	}
	
	@GetMapping("/numero-giornata")
	public RicercaResponseGiornata findAllNumGiornate() {
		
		List<Integer> numGiornate = giornataService.findAllNumGiornate();
		List<Object> result = new ArrayList<>();
		
		result.add(numGiornate);
		
		EsitoRicerca esitoRicerca = giornataService.getInfoEsitoRicercaGiornataForObject(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setAltraListaGiornate(result);
		
		return ricercaResponse;
	}
}
