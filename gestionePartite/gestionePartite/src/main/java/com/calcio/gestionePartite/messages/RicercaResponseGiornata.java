package com.calcio.gestionePartite.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.gestionePartite.entities.GiornataEntity;

@Component
public class RicercaResponseGiornata {
	
	private List<GiornataEntity> listaGiornate;
	private EsitoRicerca esitoRicerca;
	private List<Object> altraListaGiornate;
	
	public List<GiornataEntity> getListaGiornate() {
		return listaGiornate;
	}
	public void setListaGiornate(List<GiornataEntity> listaGiornate) {
		this.listaGiornate = listaGiornate;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}
	public List<Object> getAltraListaGiornate() {
		return altraListaGiornate;
	}
	public void setAltraListaGiornate(List<Object> altraListaGiornate) {
		this.altraListaGiornate = altraListaGiornate;
	}

}
