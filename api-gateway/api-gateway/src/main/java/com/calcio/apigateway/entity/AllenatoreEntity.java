package com.calcio.apigateway.entity;


public class AllenatoreEntity {
	

	private Long idAllenatore;
	private SquadraEntity idSquadra;
	private String nomeAllenatore;
	private String cognomeAllenatore;
	private int etaAllenatore;
	private String nazionalitaAllenatore;
	private double altezzaAllenatore;
	private int pesoAllenatore;
	private boolean flgCancellatoAllenatore;
	
	public AllenatoreEntity() {}

	public Long getIdAllenatore() {
		return idAllenatore;
	}

	public void setIdAllenatore(Long idAllenatore) {
		this.idAllenatore = idAllenatore;
	}

	public SquadraEntity getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(SquadraEntity idSquadra) {
		this.idSquadra = idSquadra;
	}

	public String getNomeAllenatore() {
		return nomeAllenatore;
	}

	public void setNomeAllenatore(String nomeAllenatore) {
		this.nomeAllenatore = nomeAllenatore;
	}

	public String getCognomeAllenatore() {
		return cognomeAllenatore;
	}

	public void setCognomeAllenatore(String cognomeAllenatore) {
		this.cognomeAllenatore = cognomeAllenatore;
	}

	public int getEtaAllenatore() {
		return etaAllenatore;
	}

	public void setEtaAllenatore(int etaAllenatore) {
		this.etaAllenatore = etaAllenatore;
	}

	public String getNazionalitaAllenatore() {
		return nazionalitaAllenatore;
	}

	public void setNazionalitaAllenatore(String nazionalitaAllenatore) {
		this.nazionalitaAllenatore = nazionalitaAllenatore;
	}

	public double getAltezzaAllenatore() {
		return altezzaAllenatore;
	}

	public void setAltezzaAllenatore(double altezzaAllenatore) {
		this.altezzaAllenatore = altezzaAllenatore;
	}

	public int getPesoAllenatore() {
		return pesoAllenatore;
	}

	public void setPesoAllenatore(int pesoAllenatore) {
		this.pesoAllenatore = pesoAllenatore;
	}

	public boolean isFlgCancellatoAllenatore() {
		return flgCancellatoAllenatore;
	}

	public void setFlgCancellatoAllenatore(boolean flgCancellatoAllenatore) {
		this.flgCancellatoAllenatore = flgCancellatoAllenatore;
	}
	
	
}


