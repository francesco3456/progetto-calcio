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

import com.calcio.gestioneFigureCalcistiche.entities.CalciatoreEntity;
import com.calcio.gestioneFigureCalcistiche.messages.EsitoRicerca;
import com.calcio.gestioneFigureCalcistiche.messages.RicercaResponseCalciatore;
import com.calcio.gestioneFigureCalcistiche.services.CalciatoreService;

@RestController
@RequestMapping("/calciatori")
public class CalciatoreController {
	
	@Autowired
	private CalciatoreService calciatoreService;
	
	@Autowired
	private RicercaResponseCalciatore ricercaResponse;
	
	
	@GetMapping
	public RicercaResponseCalciatore getAllCalciatori() {

		List<CalciatoreEntity> calciatori = calciatoreService.getAllCalciatori();
		EsitoRicerca esitoRicerca = calciatoreService.getInfoEsitoRicercaCalciatore(calciatori);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCalciatori(calciatori);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{id}")
	public RicercaResponseCalciatore getCalciatore(@PathVariable Long id) {
		
		List<CalciatoreEntity> result = new ArrayList<>();
		
		CalciatoreEntity calciatore = calciatoreService.getCalciatore(id);
		result.add(calciatore);
		
		EsitoRicerca esitoRicerca = calciatoreService.getInfoEsitoRicercaCalciatore(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCalciatori(result);
		
		return ricercaResponse;
	}
	
	@GetMapping("/gruppo/{squadra}")
	public RicercaResponseCalciatore getCalciatoriBySquadra(@PathVariable Long squadra) {
		
		List<CalciatoreEntity> calciatori = calciatoreService.getCalciatoriBySquadra(squadra);
		EsitoRicerca esitoRicerca = calciatoreService.getInfoEsitoRicercaCalciatore(calciatori);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCalciatori(calciatori);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseCalciatore insertCalciatore(@RequestBody CalciatoreEntity calciatoreEntity) {
		
		List<CalciatoreEntity> result = new ArrayList<>();
		
		CalciatoreEntity calciatore = calciatoreService.insertCalciatore(calciatoreEntity);
		result.add(calciatore);
		
		EsitoRicerca esitoRicerca = calciatoreService.getInfoEsitoRicercaCalciatore(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCalciatori(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("/{id}")
	public RicercaResponseCalciatore updateCalciatore(@RequestBody CalciatoreEntity calciatoreEntity, @PathVariable Long id) {
		
		List<CalciatoreEntity> result = new ArrayList<>();
		
		CalciatoreEntity calciatore = calciatoreService.updateCalciatore(calciatoreEntity, id);
		result.add(calciatore);
		
		EsitoRicerca esitoRicerca = calciatoreService.getInfoEsitoRicercaCalciatore(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaCalciatori(result);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCalciatore(@PathVariable Long id) {
		
		calciatoreService.deleteCalciatore(id);
				
	}

}
