package com.calcio.apigateway.entity;



public class CalciatoreEntity {
	
	private Long idCalciatore;
	private SquadraEntity squadra;
	private String ruoloCalciatore;
	private String nomeCalciatore;
	private String cognomeCalciatore;
	private int etaCalciatore;
	private String nazionalitaCalciatore;
	private double altezzaCalciatore;
	private int pesoCalciatore;
	private boolean flgCancellatoCalciatore;
	
	public CalciatoreEntity () {}

	public Long getIdCalciatore() {
		return idCalciatore;
	}

	public void setIdCalciatore(Long idCalciatore) {
		this.idCalciatore = idCalciatore;
	}

	public SquadraEntity getSquadra() {
		return squadra;
	}

	public void setSquadra(SquadraEntity squadra) {
		this.squadra = squadra;
	}

	public String getRuoloCalciatore() {
		return ruoloCalciatore;
	}

	public void setRuoloCalciatore(String ruoloCalciatore) {
		this.ruoloCalciatore = ruoloCalciatore;
	}

	public String getNomeCalciatore() {
		return nomeCalciatore;
	}

	public void setNomeCalciatore(String nomeCalciatore) {
		this.nomeCalciatore = nomeCalciatore;
	}

	public String getCognomeCalciatore() {
		return cognomeCalciatore;
	}

	public void setCognomeCalciatore(String cognomeCalciatore) {
		this.cognomeCalciatore = cognomeCalciatore;
	}

	public int getEtaCalciatore() {
		return etaCalciatore;
	}

	public void setEtaCalciatore(int etaCalciatore) {
		this.etaCalciatore = etaCalciatore;
	}

	public String getNazionalitaCalciatore() {
		return nazionalitaCalciatore;
	}

	public void setNazionalitaCalciatore(String nazionalitaCalciatore) {
		this.nazionalitaCalciatore = nazionalitaCalciatore;
	}

	public double getAltezzaCalciatore() {
		return altezzaCalciatore;
	}

	public void setAltezzaCalciatore(double altezzaCalciatore) {
		this.altezzaCalciatore = altezzaCalciatore;
	}

	public int getPesoCalciatore() {
		return pesoCalciatore;
	}

	public void setPesoCalciatore(int pesoCalciatore) {
		this.pesoCalciatore = pesoCalciatore;
	}

	public boolean isFlgCancellatoCalciatore() {
		return flgCancellatoCalciatore;
	}

	public void setFlgCancellatoCalciatore(boolean flgCancellatoCalciatore) {
		this.flgCancellatoCalciatore = flgCancellatoCalciatore;
	}
	
}


