package com.calcio.gestionePartite.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.gestionePartite.entities.DettaglioPartitaEntity;

@Component
public class RicercaResponseDettaglioPartita {
	
	private List<DettaglioPartitaEntity> listaDettagliPartita;
	private EsitoRicerca esitoRicerca;
	private List<Object> altraListaDettagliPartita;
	
	public List<DettaglioPartitaEntity> getListaDettagliPartita() {
		return listaDettagliPartita;
	}
	public void setListaDettagliPartita(List<DettaglioPartitaEntity> listaDettagliPartita) {
		this.listaDettagliPartita = listaDettagliPartita;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}
	public List<Object> getAltraListaDettagliPartita() {
		return altraListaDettagliPartita;
	}
	public void setAltraListaDettagliPartita(List<Object> altraListaDettagliPartita) {
		this.altraListaDettagliPartita = altraListaDettagliPartita;
	}

}
