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

import com.calcio.gestionePartite.entities.PartitaEntity;
import com.calcio.gestionePartite.messages.EsitoRicerca;
import com.calcio.gestionePartite.messages.RicercaResponsePartita;
import com.calcio.gestionePartite.services.PartitaService;

@RestController
@RequestMapping("/partite")
public class PartitaController {

	@Autowired
	private PartitaService partitaService;
	
	@Autowired
	private RicercaResponsePartita ricercaResponse;
	
	@GetMapping
	public RicercaResponsePartita getAllPartite() {
		
		List<PartitaEntity> partite = partitaService.findAllPartite();
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(partite);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(partite);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{id}")
	public RicercaResponsePartita getPartitaById(@PathVariable Long id) {
		
		PartitaEntity partita = partitaService.findPartitaById(id);
		List<PartitaEntity> result = new ArrayList<>();
		
		result.add(partita);
		
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(result);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponsePartita insertPartite(@RequestBody PartitaEntity partitaEntity) {
		
		PartitaEntity partita = partitaService.inserPartita(partitaEntity);
		List<PartitaEntity> result = new ArrayList<>();
		
		result.add(partita);
		
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("/{id}")
	public RicercaResponsePartita updatePartite(@RequestBody PartitaEntity partitaEntity, @PathVariable Long id) {
		
		PartitaEntity partita = partitaService.updatePartita(partitaEntity, id);
		List<PartitaEntity> result = new ArrayList<>();
		
		result.add(partita);
		
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(result);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("/{id}")
	public void deletePartita(@PathVariable Long id) {
		
		partitaService.deletePartita(id);
	}
	
	@GetMapping("/partite-di-oggi")
	public RicercaResponsePartita findMatchDay() {
		
		List<PartitaEntity> partite = partitaService.findMatchDay();
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(partite);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(partite);
		
		return ricercaResponse;
	}
	
	@GetMapping("/partite-di-ieri")
	public RicercaResponsePartita findMatchYesterday() {
		
		List<PartitaEntity> partite = partitaService.findMatchYesterday();
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(partite);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(partite);
		
		return ricercaResponse;
	}
	
	@GetMapping("/partite-di-domani")
	public RicercaResponsePartita findMatchTomorrow() {
		
		List<PartitaEntity> partite = partitaService.findMatchTomorrow();
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(partite);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(partite);
		
		return ricercaResponse;
	}
	
	@GetMapping("/partite-giornata/{idGiornata}/{idCampionato}")
	public RicercaResponsePartita findMatchByGiornata(@PathVariable Integer idGiornata, @PathVariable Integer idCampionato) {
		
		List<PartitaEntity> partite = partitaService.findMatchByGiornata(idGiornata, idCampionato);
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(partite);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(partite);
		
		return ricercaResponse;
	}
	
	@GetMapping("/partite-squadra/{nomeSquadra}")
	public RicercaResponsePartita findLastFiveMatchBySquadra(@PathVariable String nomeSquadra) {
		
		List<PartitaEntity> partite = partitaService.findLastFiveMatchBySquadra(nomeSquadra);
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(partite);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(partite);
		
		return ricercaResponse;
	}
	
	@GetMapping("/ultime-partite/{idCampionato}")
	public RicercaResponsePartita findRecentMatch(@PathVariable Integer idCampionato) {
		
		List<PartitaEntity> partite = partitaService.findRecentMatch(idCampionato);
		EsitoRicerca esitoRicerca = partitaService.getInfoEsitoRicercaPartita(partite);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPartite(partite);
		
		return ricercaResponse;
	}
}
