package com.calcio.apigateway.entity;


public class StatsCalciatoreEntity {
	
	private Long idStatsCalciatore;
	private int golCalciatore;
	private int assistCalciatore;
	private String calciatore;
	private String codiceSquadra;
	private boolean flgCancellatoStatsCalciatore;
	private String nazioneSquadra;
	
	public StatsCalciatoreEntity() {}

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

	public String getCalciatore() {
		return calciatore;
	}

	public void setCalciatore(String calciatore) {
		this.calciatore = calciatore;
	}

	public boolean isFlgCancellatoStatsCalciatore() {
		return flgCancellatoStatsCalciatore;
	}

	public void setFlgCancellatoStatsCalciatore(boolean flgCancellatoStatsCalciatore) {
		this.flgCancellatoStatsCalciatore = flgCancellatoStatsCalciatore;
	}

	public String getNazioneSquadra() {
		return nazioneSquadra;
	}

	public void setNazioneSquadra(String nazioneSquadra) {
		this.nazioneSquadra = nazioneSquadra;
	}
	
	public String getCodiceSquadra() {
		return codiceSquadra;
	}

	public void setCodiceSquadra(String codiceSquadra) {
		this.codiceSquadra = codiceSquadra;
	}

}
