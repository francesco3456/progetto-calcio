package com.calcio.apigateway.frontendController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.calcio.apigateway.entity.CalciatoreEntity;
import com.calcio.apigateway.entity.CalciatoriSquadra;
import com.calcio.apigateway.entity.StatsCalciatoreEntity;
import com.calcio.apigateway.messages.RicercaResponseCalciatore;
import com.calcio.apigateway.messages.RicercaResponseStats;

@RestController
@RequestMapping("/recupero-stats")
public class InterController {

	private RestTemplate restTemplate;
	
	@Autowired
    public InterController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
	
	@GetMapping("/calciatori/{squadra}/{codiceSquadra}")
	public List<CalciatoriSquadra> getCalciatoriBySquadra(@PathVariable Long squadra, @PathVariable String codiceSquadra) {
	    RicercaResponseCalciatore ricercaResponseCalciatore = restTemplate.getForObject("http://localhost:9090/calciatori/gruppo/" + squadra, RicercaResponseCalciatore.class);
	    List<CalciatoreEntity> calciatori = ricercaResponseCalciatore.getListaCalciatori();
	    
	    System.out.println(calciatori);

	    // Stampa la risposta per debug
	    System.out.println("Risposta del servizio calciatori: " + ricercaResponseCalciatore);
	    for (CalciatoreEntity calciatore : calciatori) {
	        System.out.println("Calciatore: " + calciatore);
	    }

	    RicercaResponseStats ricercaResponseStats = restTemplate.getForObject("http://localhost:9092/stats-calciatori/calciatori/" + codiceSquadra, RicercaResponseStats.class);
	    List<StatsCalciatoreEntity> stats = ricercaResponseStats.getListaStatsCalciatori();
	    
	    System.out.println(stats);

	    Map<String, CalciatoreEntity> calciatoreMap = new HashMap<>();
	    for (CalciatoreEntity calciatore : calciatori) {
	        calciatoreMap.put(calciatore.getCodiceCalciatore(), calciatore);
	    }

	    // Unione delle liste
	    List<CalciatoriSquadra> statsCalciatori = new ArrayList<>();
	    for (StatsCalciatoreEntity statistiche : stats) {
	        CalciatoreEntity calciatoreEntity = calciatoreMap.get(statistiche.getCalciatore());
	        if (calciatoreEntity != null) {
	            statsCalciatori.add(new CalciatoriSquadra(statistiche, calciatoreEntity));
	        } else {
	            System.out.println("Calciatore non trovato per il codice: " + statistiche.getCalciatore());
	        }
	    }

	    return statsCalciatori;
	    
	}

}
