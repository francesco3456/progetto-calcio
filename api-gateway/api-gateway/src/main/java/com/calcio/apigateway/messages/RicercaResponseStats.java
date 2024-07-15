package com.calcio.apigateway.messages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.calcio.apigateway.entity.StatsCalciatoreEntity;


@Component
public class RicercaResponseStats {
	
	private List<StatsCalciatoreEntity> listaStatsCalciatori;
	private EsitoRicerca esitoRicerca;
	
	public List<StatsCalciatoreEntity> getListaStatsCalciatori() {
		return listaStatsCalciatori;
	}
	public void setListaStatsCalciatori(List<StatsCalciatoreEntity> listaStatsCalciatori) {
		this.listaStatsCalciatori = listaStatsCalciatori;
	}
	public EsitoRicerca getEsitoRicerca() {
		return esitoRicerca;
	}
	public void setEsitoRicerca(EsitoRicerca esitoRicerca) {
		this.esitoRicerca = esitoRicerca;
	}

}
