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

import com.calcio.gestioneFigureCalcistiche.entities.SquadraEntity;
import com.calcio.gestioneFigureCalcistiche.messages.EsitoRicerca;
import com.calcio.gestioneFigureCalcistiche.messages.RicercaResponseSquadra;
import com.calcio.gestioneFigureCalcistiche.services.SquadraService;

@RestController
@RequestMapping("/squadre")
public class SquadraController {
	
	@Autowired
	private SquadraService squadraService;
	
	@Autowired
	private RicercaResponseSquadra ricercaResponse;
	
	@GetMapping
	public RicercaResponseSquadra getAllSquadre() {
		
		List<SquadraEntity> squadre = squadraService.getAllSquadre();
		EsitoRicerca esitoRicerca = squadraService.getInfoEsitoRicercaSquadra(squadre);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaSquadre(squadre);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{id}")
	public RicercaResponseSquadra getSquadra(@PathVariable Long id) {
		
		SquadraEntity squadra = squadraService.getSquadra(id);
		List<SquadraEntity> result = new ArrayList<>();
		
		result.add(squadra);
		
		EsitoRicerca esitoRicerca = squadraService.getInfoEsitoRicercaSquadra(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaSquadre(result);
		
		return ricercaResponse;
	}
	
	@GetMapping("/squadra/{nome}")
	public RicercaResponseSquadra getNomeSquadra(@PathVariable String nome) {
		
		SquadraEntity squadra = squadraService.getNomeSquadra(nome);
		List<SquadraEntity> result = new ArrayList<>();
		
		result.add(squadra);
		
		EsitoRicerca esitoRicerca = squadraService.getInfoEsitoRicercaSquadra(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaSquadre(result);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseSquadra insertSquadra(@RequestBody SquadraEntity squadraEntity) {
		
		SquadraEntity squadra = squadraService.insertSquadra(squadraEntity);
		List<SquadraEntity> result = new ArrayList<>();
		
		result.add(squadra);
		
		EsitoRicerca esitoRicerca = squadraService.getInfoEsitoRicercaSquadra(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaSquadre(result);
		
		return ricercaResponse;
		
	}
	
	@PutMapping("/{id}")
	public RicercaResponseSquadra updateSquadra(@RequestBody SquadraEntity squadraEntity, @PathVariable Long id) {
		
		SquadraEntity squadra = squadraService.updateSquadra(id, squadraEntity);
		List<SquadraEntity> result = new ArrayList<>();
		
		result.add(squadra);
		
		EsitoRicerca esitoRicerca = squadraService.getInfoEsitoRicercaSquadra(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaSquadre(result);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("/{id}")
	public void deleteSquadra(@PathVariable Long id) {
		
		squadraService.deleteSquadra(id);
	}

}
