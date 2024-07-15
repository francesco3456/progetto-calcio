package com.calcio.apigateway.entity;



public class CalciatoreEntity {
	
	private Long idCalciatore;
	private SquadraEntity squadra;
	private String ruoloCalciatore;
	private String nome;
	private String cognome;
	private int eta;
	private String nazionalita;
	private double altezza;
	private int peso;
	private boolean flgCancellatoCalciatore;
	private String codiceCalciatore;

	public CalciatoreEntity () {}
	
	public String getCodiceCalciatore() {
		return codiceCalciatore;
	}

	public void setCodiceCalciatore(String codiceCalciatore) {
		this.codiceCalciatore = codiceCalciatore;
	}

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean isFlgCancellatoCalciatore() {
		return flgCancellatoCalciatore;
	}

	public void setFlgCancellatoCalciatore(boolean flgCancellatoCalciatore) {
		this.flgCancellatoCalciatore = flgCancellatoCalciatore;
	}

	@Override
	public String toString() {
		return "CalciatoreEntity [idCalciatore=" + idCalciatore + ", squadra=" + squadra + ", ruoloCalciatore="
				+ ruoloCalciatore + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", nazionalita="
				+ nazionalita + ", altezza=" + altezza + ", peso=" + peso + ", flgCancellatoCalciatore="
				+ flgCancellatoCalciatore + ", codiceCalciatore=" + codiceCalciatore + "]";
	}

	
}


