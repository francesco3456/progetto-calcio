package com.calcio.gestioneFigureCalcistiche.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.gestioneFigureCalcistiche.entities.CalciatoreEntity;

@Component
public class RicercaResponseCalciatore {
	
	private List<CalciatoreEntity> listaCalciatori;
	private EsitoRicerca esitoRicerca;
	
	public List<CalciatoreEntity> getListaCalciatori() {
		return listaCalciatori;
	}
	public void setListaCalciatori(List<CalciatoreEntity> listaCalciatori) {
		this.listaCalciatori = listaCalciatori;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}
	
	

}
