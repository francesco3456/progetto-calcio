package com.calcio.apigateway.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.apigateway.entity.ClassificaEntity;


@Component
public class RicercaResponseClassifica {
	
	private List<ClassificaEntity> listaPunteggi;
	private EsitoRicerca esitoRicerca;
	
	public List<ClassificaEntity> getListaPunteggi() {
		return listaPunteggi;
	}
	public void setListaPunteggi(List<ClassificaEntity> listaPunteggi) {
		this.listaPunteggi = listaPunteggi;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}

}
