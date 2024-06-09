package com.calcio.apigateway.frontendController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.calcio.apigateway.entity.PartitaEntity;
import com.calcio.apigateway.messages.RicercaResponseCampionato;
import com.calcio.apigateway.messages.RicercaResponsePartita;

@CrossOrigin(origins = "http://localhost:8765")
@RestController
@RequestMapping("/home")
public class HomePageController {
	
	private RestTemplate restTemplate;
	
	@Autowired
    public HomePageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
	
	@GetMapping("/menu")
	@ResponseBody
	public List<Object> getMenuData(Model model) {
	    RicercaResponseCampionato ricercaResponse = restTemplate.getForObject("http://localhost:9091/campionati/nomi-campionati", RicercaResponseCampionato.class);
	    return ricercaResponse.getAltraListaCampionati();
	}
	
	@GetMapping("/matchYesterday")
	@ResponseBody
	public List<PartitaEntity> getMatchYesterday(Model model) {
		
		RicercaResponsePartita ricercaResponse = restTemplate.getForObject("http://localhost:9091/partite/partite-di-ieri", RicercaResponsePartita.class);
		return ricercaResponse.getListaPartite();
	}
	
	@GetMapping("/matchday")
	@ResponseBody
	public List<PartitaEntity> getMatchday() {
		
		RicercaResponsePartita ricercaResponse = restTemplate.getForObject("http://localhost:9091/partite/partite-di-oggi", RicercaResponsePartita.class);
		return ricercaResponse.getListaPartite();
	}
	
	@GetMapping("/matchTomorrow")
	@ResponseBody
	public List<PartitaEntity> getMatchTomorrow() {
		
		RicercaResponsePartita ricercaResponse = restTemplate.getForObject("http://localhost:9091/partite/partite-di-domani", RicercaResponsePartita.class);
		return ricercaResponse.getListaPartite();
	}
	


}
