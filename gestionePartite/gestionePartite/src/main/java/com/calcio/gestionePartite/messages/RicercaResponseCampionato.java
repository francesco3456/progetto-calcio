package com.calcio.gestionePartite.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.gestionePartite.entities.CampionatoEntity;

@Component
public class RicercaResponseCampionato {
	
	private List<CampionatoEntity> listaCampionati;
	private EsitoRicerca esitoRicerca;
	private List<Object> altraListaCampionati;
	
	public List<CampionatoEntity> getListaCampionati() {
		return listaCampionati;
	}
	public void setListaCampionati(List<CampionatoEntity> listaCampionati) {
		this.listaCampionati = listaCampionati;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}
	public List<Object> getAltraListaCampionati() {
		return altraListaCampionati;
	}
	public void setAltraListaCampionati(List<Object> altraListaCampionati) {
		this.altraListaCampionati = altraListaCampionati;
	}

}
