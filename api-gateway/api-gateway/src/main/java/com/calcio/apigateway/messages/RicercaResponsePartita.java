package com.calcio.apigateway.messages;

import java.util.List;


import org.springframework.stereotype.Component;

import com.calcio.apigateway.entity.PartitaEntity;


@Component
public class RicercaResponsePartita {
	
	private List<PartitaEntity> listaPartite;
	private EsitoRicerca esitoRicerca;
	
	public List<PartitaEntity> getListaPartite() {
		return listaPartite;
	}
	public void setListaPartite(List<PartitaEntity> listaPartite) {
		this.listaPartite = listaPartite;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}

}
