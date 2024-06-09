package com.calcio.gestionePartite.dto;

import java.time.LocalDateTime;

public class GiornataDto {
	
	private Long idGiornata;
	private LocalDateTime inizioGiornata;
	private LocalDateTime fineGiornata;
	private int numeroGiornata;
	
	public GiornataDto() {}
	
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

	public int getNumeroGiornata() {
		return numeroGiornata;
	}

	public void setNumeroGiornata(int numeroGiornata) {
		this.numeroGiornata = numeroGiornata;
	}

	@Override
	public String toString() {
		return "GiornataDto [idGiornata=" + idGiornata + ", inizioGiornata=" + inizioGiornata + ", fineGiornata="
				+ fineGiornata + ", numeroGiornata=" + numeroGiornata + "]";
	}


}
