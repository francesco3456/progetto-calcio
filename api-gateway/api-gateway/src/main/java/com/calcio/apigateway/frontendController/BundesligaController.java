package com.calcio.apigateway.frontendController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.calcio.apigateway.entity.ClassificaEntity;
import com.calcio.apigateway.entity.PartitaEntity;
import com.calcio.apigateway.entity.Punteggi;
import com.calcio.apigateway.entity.SquadraEntity;
import com.calcio.apigateway.messages.RicercaResponseClassifica;
import com.calcio.apigateway.messages.RicercaResponseGiornata;
import com.calcio.apigateway.messages.RicercaResponsePartita;
import com.calcio.apigateway.messages.RicercaResponseSquadra;


@RestController
@RequestMapping("/lega-tedesca")
public class BundesligaController {
	
	private RestTemplate restTemplate;
	
	@Autowired
    public BundesligaController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
	
	@GetMapping("/giornata")
	@ResponseBody
	public List<Object> getNumGiornate() {
	    RicercaResponseGiornata ricercaResponse = restTemplate.getForObject("http://localhost:9091/giornate/numero-giornata", RicercaResponseGiornata.class);
	    return ricercaResponse.getAltraListaGiornate();
	}
	
	@GetMapping("/punteggi")
	@ResponseBody
	public List<Punteggi> getPunteggi() {
	    // Ottieni la classifica
	    RicercaResponseClassifica ricercaResponse = restTemplate.getForObject("http://localhost:9092/classifica/scelta-campionato/Germania", RicercaResponseClassifica.class);
	    List<ClassificaEntity> classifica = ricercaResponse.getListaPunteggi();

	    // Ottieni le squadre
	    RicercaResponseSquadra ricercaResponseSquadra = restTemplate.getForObject("http://localhost:9090/squadre", RicercaResponseSquadra.class);
	    List<SquadraEntity> squadre = ricercaResponseSquadra.getListaSquadre();

	    // Crea una mappa delle squadre usando il codice come chiave
	    Map<String, SquadraEntity> squadraMap = new HashMap<>();
	    for (SquadraEntity squadra : squadre) {
	        squadraMap.put(squadra.getCodiceSquadra(), squadra);
	    }

	    // Unisci le liste
	    List<Punteggi> punteggi = new ArrayList<>();
	    for (ClassificaEntity classificaEntity : classifica) {
	        SquadraEntity squadraEntity = squadraMap.get(classificaEntity.getCodiceSquadra());
	        if (squadraEntity != null) {
	            punteggi.add(new Punteggi(classificaEntity, squadraEntity));
	        } else {
	            // Gestione nel caso in cui il codice della squadra non corrisponda a nessuna squadra nel database
	            System.out.println("Squadra non trovata nel database per il codice: " + classificaEntity.getCodiceSquadra());
	        }
	    }

	    return punteggi;
	}
	
	@GetMapping("/ultime-partite")
	@ResponseBody
	public List<PartitaEntity> getUltimePartite() {
		RicercaResponsePartita ricercaResponse = restTemplate.getForObject("http://localhost:9091/partite/ultime-partite/7", RicercaResponsePartita.class);
		return ricercaResponse.getListaPartite();
	}
	
	@GetMapping("/partite-giornata/{idGiornata}/{idCampionato}")
	@ResponseBody
	public List<PartitaEntity> getPartiteByGiornata(@PathVariable Long idCampionato, @PathVariable Long idGiornata) {
		
		RicercaResponsePartita ricercaResponse = restTemplate.getForObject("http://localhost:9091/partite/partite-giornata/"+ idGiornata + "/"+ idCampionato, RicercaResponsePartita.class);
		
		System.out.println(ricercaResponse.getListaPartite());
		
		return ricercaResponse.getListaPartite();
		
	}
}
