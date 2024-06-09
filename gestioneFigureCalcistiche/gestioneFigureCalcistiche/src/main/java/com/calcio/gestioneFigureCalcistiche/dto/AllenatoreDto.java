package com.calcio.gestioneFigureCalcistiche.dto;

import org.springframework.stereotype.Component;

import com.calcio.gestioneFigureCalcistiche.entities.entityInterface.Persona;

@Component
public class AllenatoreDto implements Persona {
	
	private Long idAllenatore;
	private Long idSquadra;
	
	private String nomeAllenatore;
	private String cognomeAllenatore;
	private int etaAllenatore;
	private String nazionalitaAllenatore;
	private double altezzaAllenatore;
	private int pesoAllenatore;
	
	public AllenatoreDto() {}

	public Long getIdAllenatore() {
		return idAllenatore;
	}

	public void setIdAllenatore(Long idAllenatore) {
		this.idAllenatore = idAllenatore;
	}

	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
	}

	@Override
	public String getNome() {
		return nomeAllenatore;
	}

	@Override
	public void setNome(String nomeAllenatore) {
		this.nomeAllenatore = nomeAllenatore;
	}

	@Override
	public String getCognome() {
		return cognomeAllenatore;
	}

	@Override
	public void setCognome(String cognomeAllenatore) {
		this.cognomeAllenatore = cognomeAllenatore;
	}

	@Override
	public int getEta() {
		return etaAllenatore;
	}

	@Override
	public void setEta(int etaAllenatore) {
		this.etaAllenatore = etaAllenatore;
	}

	@Override
	public String getNazionalita() {
		return nazionalitaAllenatore;
	}

	@Override
	public void setNazionalita(String nazionalitaAllenatore) {
		this.nazionalitaAllenatore = nazionalitaAllenatore;
	}

	@Override
	public double getAltezza() {
		return altezzaAllenatore;
	}

	@Override
	public void setAltezza(double altezzaAllenatore) {
		this.altezzaAllenatore = altezzaAllenatore;
	}

	@Override
	public int getPeso() {
		return pesoAllenatore;
	}

	@Override
	public void setPeso(int pesoAllenatore) {
		this.pesoAllenatore = pesoAllenatore;
	}

	@Override
	public String toString() {
		return "AllenatoreBean [idAllenatore=" + idAllenatore + ", idSquadra=" + idSquadra + ", nomeAllenatore="
				+ nomeAllenatore + ", cognomeAllenatore=" + cognomeAllenatore + ", etaAllenatore=" + etaAllenatore
				+ ", nazionalitaAllenatore=" + nazionalitaAllenatore + ", altezzaAllenatore=" + altezzaAllenatore
				+ ", pesoAllenatore=" + pesoAllenatore + "]";
	}

}
