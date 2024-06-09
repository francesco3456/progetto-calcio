package com.calcio.gestioneFigureCalcistiche.dto;

import org.springframework.stereotype.Component;

import com.calcio.gestioneFigureCalcistiche.entities.entityInterface.Persona;

@Component
public class CalciatoreDto implements Persona{
	
	private Long idCalciatore;
	private Long idSquadra;
	private String ruoloCalciatore;
	
	private String nomeCalciatore;
	private String cognomeCalciatore;
	private int etaCalciatore;
	private String nazionalitaCalciatore;
	private double altezzaCalciatore;
	private int pesoCalciatore;
	
	public CalciatoreDto () {}
	
	public Long getIdCalciatore() {
		return idCalciatore;
	}

	public void setIdCalciatore(Long idCalciatore) {
		this.idCalciatore = idCalciatore;
	}

	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
	}

	public String getRuoloCalciatore() {
		return ruoloCalciatore;
	}

	public void setRuoloCalciatore(String ruoloCalciatore) {
		this.ruoloCalciatore = ruoloCalciatore;
	}

	@Override
	public String getNome() {
		return nomeCalciatore;
	}

	@Override
	public void setNome(String nomeCalciatore) {
		this.nomeCalciatore = nomeCalciatore;
	}

	@Override
	public String getCognome() {
		return cognomeCalciatore;
	}

	@Override
	public void setCognome(String cognomeCalciatore) {
		this.cognomeCalciatore = cognomeCalciatore;
	}

	@Override
	public int getEta() {
		return etaCalciatore;
	}

	@Override
	public void setEta(int etaCalciatore) {
		this.etaCalciatore = etaCalciatore;
	}

	@Override
	public String getNazionalita() {
		return nazionalitaCalciatore;
	}

	@Override
	public void setNazionalita(String nazionalitaCalciatore) {
		this.nazionalitaCalciatore = nazionalitaCalciatore;
	}

	@Override
	public double getAltezza() {
		return altezzaCalciatore;
	}

	@Override
	public void setAltezza(double altezzaCalciatore) {
		this.altezzaCalciatore = altezzaCalciatore;
	}

	@Override
	public int getPeso() {
		return pesoCalciatore;
	}

	@Override
	public void setPeso(int pesoCalciatore) {
		this.pesoCalciatore = pesoCalciatore;
	}

	@Override
	public String toString() {
		return "CalciatoreBean [idCalciatore=" + idCalciatore + ", idSquadra=" + idSquadra + ", ruoloCalciatore="
				+ ruoloCalciatore + ", nomeCalciatore=" + nomeCalciatore + ", cognomeCalciatore=" + cognomeCalciatore
				+ ", etaCalciatore=" + etaCalciatore + ", nazionalitaCalciatore=" + nazionalitaCalciatore
				+ ", altezzaCalciatore=" + altezzaCalciatore + ", pesoCalciatore=" + pesoCalciatore + "]";
	}

}
