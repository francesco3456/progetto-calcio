package com.calcio.gestioneFigureCalcistiche.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.gestioneFigureCalcistiche.entities.AllenatoreEntity;

@Component
public class RicercaResponseAllenatore {
	
	private List<AllenatoreEntity> listaAllenatori;
	private EsitoRicerca esitoRicerca;
	
	public List<AllenatoreEntity> getListaAllenatori() {
		return listaAllenatori;
	}
	public void setListaAllenatori(List<AllenatoreEntity> listaAllenatori) {
		this.listaAllenatori = listaAllenatori;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}

}
