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

import com.calcio.gestionePartite.entities.DettaglioPartitaEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.messages.RicercaResponseDettaglioPartita;
import com.calcio.gestionePartite.services.DettaglioPartitaService;

@RestController
@RequestMapping("/dettagli-partite")
public class DettaglioPartitaController {
	
	@Autowired
	private DettaglioPartitaService dettaglioService;
	
	@Autowired
	private RicercaResponseDettaglioPartita ricercaResponse;
	
	@GetMapping
	public RicercaResponseDettaglioPartita getAllDettagli() {
		
		List<DettaglioPartitaEntity> dettagli = dettaglioService.findAllDettagli();
		EsitoRicerca esitoRicerca = dettaglioService.getInfoEsitoRicercaDettaglio(dettagli);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaDettagliPartita(dettagli);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{id}")
	public RicercaResponseDettaglioPartita getDettaglioById(@PathVariable Long id) {
		
		DettaglioPartitaEntity dettaglio = dettaglioService.findDettagliById(id);
		List<DettaglioPartitaEntity> result = new ArrayList<>();
		
		result.add(dettaglio);
		
		EsitoRicerca esitoRicerca = dettaglioService.getInfoEsitoRicercaDettaglio(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaDettagliPartita(result);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseDettaglioPartita insertDettaglio(@RequestBody DettaglioPartitaEntity dettaglioPartitaEntity) {
		
		DettaglioPartitaEntity campionato = dettaglioService.insertDettaglio(dettaglioPartitaEntity);
		List<DettaglioPartitaEntity> result = new ArrayList<>();
		
		result.add(campionato);
		
		EsitoRicerca esitoRicerca = dettaglioService.getInfoEsitoRicercaDettaglio(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaDettagliPartita(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("/{id}")
	public RicercaResponseDettaglioPartita updateDettaglio(@RequestBody DettaglioPartitaEntity dettaglioEntity, @PathVariable Long id) {
		
		DettaglioPartitaEntity campionato = dettaglioService.updateDettaglio(dettaglioEntity, id);
		List<DettaglioPartitaEntity> result = new ArrayList<>();
		
		result.add(campionato);
		
		EsitoRicerca esitoRicerca = dettaglioService.getInfoEsitoRicercaDettaglio(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaDettagliPartita(result);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("/{id}")
	public void deleteDettaglio(@PathVariable Long id) {
		
		dettaglioService.deleteDettaglio(id);
	}

}
