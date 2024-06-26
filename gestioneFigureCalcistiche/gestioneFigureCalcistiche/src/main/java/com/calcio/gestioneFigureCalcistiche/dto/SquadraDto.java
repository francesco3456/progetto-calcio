package com.calcio.gestioneFigureCalcistiche.dto;

import java.sql.Blob;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class SquadraDto {
	
	private Long idSquadra;
	private String nomeSquadra;
	private String nazionalitaSquadra;
	private LocalDate nascitaSquadra;
	private String stadioSquadra;
	private String cittaSquadra;
	private Blob stemmaSquadra;
	
	public SquadraDto() {}
	
	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public String getNazionalitaSquadra() {
		return nazionalitaSquadra;
	}

	public void setNazionalitaSquadra(String nazionalitaSquadra) {
		this.nazionalitaSquadra = nazionalitaSquadra;
	}

	public LocalDate getNascitaSquadra() {
		return nascitaSquadra;
	}

	public void setNascitaSquadra(LocalDate nascitaSquadra) {
		this.nascitaSquadra = nascitaSquadra;
	}

	public String getStadioSquadra() {
		return stadioSquadra;
	}

	public void setStadioSquadra(String stadioSquadra) {
		this.stadioSquadra = stadioSquadra;
	}

	public String getCittaSquadra() {
		return cittaSquadra;
	}

	public void setCittaSquadra(String cittaSquadra) {
		this.cittaSquadra = cittaSquadra;
	}

	public Blob getStemmaSquadra() {
		return stemmaSquadra;
	}

	public void setStemmaSquadra(Blob stemmaSquadra) {
		this.stemmaSquadra = stemmaSquadra;
	}

	@Override
	public String toString() {
		return "SquadraDto [idSquadra=" + idSquadra + ", nomeSquadra=" + nomeSquadra + ", nazionalitaSquadra="
				+ nazionalitaSquadra + ", nascitaSquadra=" + nascitaSquadra + ", stadioSquadra=" + stadioSquadra
				+ ", cittaSquadra=" + cittaSquadra + ", stemmaSquadra=" + stemmaSquadra + "]";
	}
}
