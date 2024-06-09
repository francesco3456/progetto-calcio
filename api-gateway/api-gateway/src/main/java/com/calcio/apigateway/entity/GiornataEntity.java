package com.calcio.apigateway.entity;

import java.time.LocalDateTime;
import java.util.List;


public class GiornataEntity {
	
	private Long idGiornata;
	private LocalDateTime inizioGiornata;
	private LocalDateTime fineGiornata;
	private int numGiornata;
	private boolean flgCancellatoGiornata;
	private List<PartitaEntity> partite;
	
	public GiornataEntity() {}

	public Long getIdGiornata() {
		return idGiornata;
	}

	public void setIdGiornata(Long idGiornata) {
		this.idGiornata = idGiornata;
	}

	public LocalDateTime getInizioGiornata() {
		return inizioGiornata;
	}

	public void setInizioGiornata(LocalDateTime inizioGiornata) {
		this.inizioGiornata = inizioGiornata;
	}

	public LocalDateTime getFineGiornata() {
		return fineGiornata;
	}

	public void setFineGiornata(LocalDateTime fineGiornata) {
		this.fineGiornata = fineGiornata;
	}

	public int getNumGiornata() {
		return numGiornata;
	}

	public void setNumGiornata(int numGiornata) {
		this.numGiornata = numGiornata;
	}

	public boolean isFlgCancellatoGiornata() {
		return flgCancellatoGiornata;
	}

	public void setFlgCancellatoGiornata(boolean flgCancellatoGiornata) {
		this.flgCancellatoGiornata = flgCancellatoGiornata;
	}

	public List<PartitaEntity> getPartite() {
		return partite;
	}

	public void setPartite(List<PartitaEntity> partite) {
		this.partite = partite;
	}

}
