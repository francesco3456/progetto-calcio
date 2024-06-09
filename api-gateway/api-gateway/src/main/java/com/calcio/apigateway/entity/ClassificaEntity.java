package com.calcio.apigateway.entity;


public class ClassificaEntity {
	
	private Long idClassifica;
	private int puntiSquadra;
	private int vittorieSquadra;
	private int pareggiSquadra;
	private int sconfitteSquadra;
	private int golFattiSquadra;
	private int golSubitiSquadra;
	private int differenzaRetiSquadra;
	private String codiceSquadra;
	private boolean flgCancellatoClassifica;
	
	public ClassificaEntity() {}

	public Long getIdClassifica() {
		return idClassifica;
	}

	public void setIdClassifica(Long idClassifica) {
		this.idClassifica = idClassifica;
	}

	public int getPuntiSquadra() {
		return puntiSquadra;
	}

	public void setPuntiSquadra(int puntiSquadra) {
		this.puntiSquadra = puntiSquadra;
	}

	public int getVittorieSquadra() {
		return vittorieSquadra;
	}

	public void setVittorieSquadra(int vittorieSquadra) {
		this.vittorieSquadra = vittorieSquadra;
	}

	public int getPareggiSquadra() {
		return pareggiSquadra;
	}

	public void setPareggiSquadra(int pareggiSquadra) {
		this.pareggiSquadra = pareggiSquadra;
	}

	public int getSconfitteSquadra() {
		return sconfitteSquadra;
	}

	public void setSconfitteSquadra(int sconfitteSquadra) {
		this.sconfitteSquadra = sconfitteSquadra;
	}

	public int getGolFattiSquadra() {
		return golFattiSquadra;
	}

	public void setGolFattiSquadra(int golFattiSquadra) {
		this.golFattiSquadra = golFattiSquadra;
	}

	public int getGolSubitiSquadra() {
		return golSubitiSquadra;
	}

	public void setGolSubitiSquadra(int golSubitiSquadra) {
		this.golSubitiSquadra = golSubitiSquadra;
	}

	public int getDifferenzaRetiSquadra() {
		return differenzaRetiSquadra;
	}

	public void setDifferenzaRetiSquadra(int differenzaRetiSquadra) {
		this.differenzaRetiSquadra = differenzaRetiSquadra;
	}

	public String getCodiceSquadra() {
		return codiceSquadra;
	}

	public void setCodiceSquadra(String codiceSquadra) {
		this.codiceSquadra = codiceSquadra;
	}

	public boolean isFlgCancellatoClassifica() {
		return flgCancellatoClassifica;
	}

	public void setFlgCancellatoClassifica(boolean flgCancellatoClassifica) {
		this.flgCancellatoClassifica = flgCancellatoClassifica;
	}
	
	

}
