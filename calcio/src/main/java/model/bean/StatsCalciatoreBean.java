package model.bean;

import java.time.LocalDateTime;

import model.beanInterface.InformazioniTabelle;

public class StatsCalciatoreBean implements InformazioniTabelle {
	
	private Long idStatsCalciatore;
	private int golCalciatore;
	private int assistCalciatore;
	private Long idCalciatore;
	private LocalDateTime dataCreazioneStatsCalciatore;
	private LocalDateTime dataModificaStatsCalciatore;
	private boolean flgCancellatoStatsCalciatore;
	
	public StatsCalciatoreBean() {}

	public StatsCalciatoreBean(Long idStatsCalciatore, int golCalciatore, int assistCalciatore, Long idCalciatore) {
		this.idStatsCalciatore = idStatsCalciatore;
		this.golCalciatore = golCalciatore;
		this.assistCalciatore = assistCalciatore;
		this.idCalciatore = idCalciatore;
	}

	public Long getIdStatsCalciatore() {
		return idStatsCalciatore;
	}

	public void setIdStatsCalciatore(Long idStatsCalciatore) {
		this.idStatsCalciatore = idStatsCalciatore;
	}

	public int getGolCalciatore() {
		return golCalciatore;
	}

	public void setGolCalciatore(int golCalciatore) {
		this.golCalciatore = golCalciatore;
	}

	public int getAssistCalciatore() {
		return assistCalciatore;
	}

	public void setAssistCalciatore(int assistCalciatore) {
		this.assistCalciatore = assistCalciatore;
	}

	public Long getIdCalciatore() {
		return idCalciatore;
	}

	public void setIdCalciatore(Long idCalciatore) {
		this.idCalciatore = idCalciatore;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneStatsCalciatore;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneStatsCalciatore) {
		this.dataCreazioneStatsCalciatore = dataCreazioneStatsCalciatore;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaStatsCalciatore;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaStatsCalciatore) {
		this.dataModificaStatsCalciatore = dataModificaStatsCalciatore;
	}

	public boolean isFlgCancellato() {
		return flgCancellatoStatsCalciatore;
	}

	public void setFlgCancellato(boolean flgCancellatoStatsCalciatore) {
		this.flgCancellatoStatsCalciatore = flgCancellatoStatsCalciatore;
	}

	@Override
	public String toString() {
		return "StatsCalciatoreBean [idStatsCalciatore=" + idStatsCalciatore + ", golCalciatore=" + golCalciatore
				+ ", assistCalciatore=" + assistCalciatore + ", idCalciatore=" + idCalciatore + "]";
	}
	
	
}
