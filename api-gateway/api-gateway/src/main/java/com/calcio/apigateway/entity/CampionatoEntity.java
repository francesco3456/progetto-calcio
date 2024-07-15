package com.calcio.apigateway.entity;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class CampionatoEntity {
	

	private Long idCampionato;
	private String nomeCampionato;
	private String nazioneCampionato;
	private LocalDateTime inizioCampionato;
	private LocalDateTime fineCampionato;
	private LocalDate stagioneCampionato;
	private int totGiornateCampionato;
	private Blob bandieraCampionato;
	private boolean flgCancellatoCampionato;
	private List<PartitaEntity> partite;
	
	public CampionatoEntity() {}

	public Long getIdCampionato() {
		return idCampionato;
	}

	public void setIdCampionato(Long idCampionato) {
		this.idCampionato = idCampionato;
	}

	public String getNomeCampionato() {
		return nomeCampionato;
	}

	public void setNomeCampionato(String nomeCampionato) {
		this.nomeCampionato = nomeCampionato;
	}

	public String getNazioneCampionato() {
		return nazioneCampionato;
	}

	public void setNazioneCampionato(String nazioneCampionato) {
		this.nazioneCampionato = nazioneCampionato;
	}

	public LocalDateTime getInizioCampionato() {
		return inizioCampionato;
	}

	public void setInizioCampionato(LocalDateTime inizioCampionato) {
		this.inizioCampionato = inizioCampionato;
	}

	public LocalDateTime getFineCampionato() {
		return fineCampionato;
	}

	public void setFineCampionato(LocalDateTime fineCampionato) {
		this.fineCampionato = fineCampionato;
	}

	public LocalDate getStagioneCampionato() {
		return stagioneCampionato;
	}

	public void setStagioneCampionato(LocalDate stagioneCampionato) {
		this.stagioneCampionato = stagioneCampionato;
	}

	public int getTotGiornateCampionato() {
		return totGiornateCampionato;
	}

	public void setTotGiornateCampionato(int totGiornateCampionato) {
		this.totGiornateCampionato = totGiornateCampionato;
	}

	public Blob getBandieraCampionato() {
		return bandieraCampionato;
	}

	public void setBandieraCampionato(Blob bandieraCampionato) {
		this.bandieraCampionato = bandieraCampionato;
	}

	public boolean isFlgCancellatoCampionato() {
		return flgCancellatoCampionato;
	}

	public void setFlgCancellatoCampionato(boolean flgCancellatoCampionato) {
		this.flgCancellatoCampionato = flgCancellatoCampionato;
	}

	public List<PartitaEntity> getPartite() {
		return partite;
	}

	public void setPartite(List<PartitaEntity> partite) {
		this.partite = partite;
	}

	
	
}