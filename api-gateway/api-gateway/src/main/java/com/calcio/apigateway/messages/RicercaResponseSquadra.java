package com.calcio.apigateway.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.apigateway.entity.SquadraEntity;


@Component
public class RicercaResponseSquadra {
	
	private List<SquadraEntity> listaSquadre;
	private EsitoRicerca esitoRicerca;
	
	public List<SquadraEntity> getListaSquadre() {
		return listaSquadre;
	}
	public void setListaSquadre(List<SquadraEntity> listaSquadre) {
		this.listaSquadre = listaSquadre;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}

}
