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

import com.calcio.gestioneClassifiche.entity.ClassificaEntity;
import com.calcio.gestioneClassifiche.messages.EsitoRicerca;
import com.calcio.gestioneClassifiche.messages.RicercaResponseClassifica;
import com.calcio.gestioneClassifiche.services.ClassificaService;

@RestController
@RequestMapping("/classifica")
public class ClassificaController {
	
	@Autowired
	RicercaResponseClassifica ricercaResponse;
	
	@Autowired
	ClassificaService classificaService;
	
	@GetMapping
	public RicercaResponseClassifica getAllPunteggi() {
		
		List<ClassificaEntity> punteggi = classificaService.findAllPunteggi();
		EsitoRicerca esitoRicerca = classificaService.getInfoEsitoRicercaClassifica(punteggi);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPunteggi(punteggi);
		
		return ricercaResponse;
	}
	
	@GetMapping("/{idPunteggio}")
	public RicercaResponseClassifica getPunteggio(@PathVariable Long idPunteggio) {
		
		ClassificaEntity punteggio = classificaService.findPunteggioById(idPunteggio);
		List<ClassificaEntity> result = new ArrayList<>();
		
		result.add(punteggio);
		
		EsitoRicerca esitoRicerca = classificaService.getInfoEsitoRicercaClassifica(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPunteggi(result);
		
		return ricercaResponse;
	}
	
	@PostMapping
	public RicercaResponseClassifica insertPunteggio(@RequestBody ClassificaEntity punteggio) {
		
		ClassificaEntity classificaEntity = classificaService.insertPunteggio(punteggio);
		List<ClassificaEntity> result = new ArrayList<>();
		
		result.add(classificaEntity);
		
		EsitoRicerca esitoRicerca = classificaService.getInfoEsitoRicercaClassifica(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPunteggi(result);
		
		return ricercaResponse;
	}
	
	@PutMapping("/{idPunteggio}")
	public RicercaResponseClassifica updatePunteggio(@RequestBody ClassificaEntity punteggio, @PathVariable Long idPunteggio) {
		
		ClassificaEntity classificaEntity = classificaService.updatePunteggio(idPunteggio, punteggio);
		List<ClassificaEntity> result = new ArrayList<>();
		
		result.add(classificaEntity);
		
		EsitoRicerca esitoRicerca = classificaService.getInfoEsitoRicercaClassifica(result);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPunteggi(result);
		
		return ricercaResponse;
		
	}
	
	@GetMapping("/scelta-campionato/{nazione}")
	public RicercaResponseClassifica getPunteggiByNazione(@PathVariable String nazione) {
		
		List<ClassificaEntity> punteggi = classificaService.findPunteggiByNazione(nazione);
		EsitoRicerca esitoRicerca = classificaService.getInfoEsitoRicercaClassifica(punteggi);
		
		ricercaResponse.setEsitoRicerca(esitoRicerca);
		ricercaResponse.setListaPunteggi(punteggi);
		
		return ricercaResponse;
	}
	
	@DeleteMapping("/{idPunteggio}")
	public void deletePunteggio(@PathVariable Long idPunteggio) {
		
		classificaService.deletePunteggio(idPunteggio);
	}

}
