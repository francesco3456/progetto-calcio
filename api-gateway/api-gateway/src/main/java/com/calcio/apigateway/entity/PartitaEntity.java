package com.calcio.apigateway.entity;

import java.time.LocalDateTime;


public class PartitaEntity {
	
	private Long idPartita;
	private String risultatoPartita;
	private LocalDateTime dataPartita;
	private boolean flgCancellatoPartita;
	private String squadraCasa;
	private String squadraOspite;
	private GiornataEntity idGiornata;
	private CampionatoEntity idCampionato;
	
	public PartitaEntity() {}

	public Long getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(Long idPartita) {
		this.idPartita = idPartita;
	}

	public String getRisultatoPartita() {
		return risultatoPartita;
	}

	public void setRisultatoPartita(String risultatoPartita) {
		this.risultatoPartita = risultatoPartita;
	}

	public LocalDateTime getDataPartita() {
		return dataPartita;
	}

	public void setDataPartita(LocalDateTime dataPartita) {
		this.dataPartita = dataPartita;
	}

	public boolean isFlgCancellatoPartita() {
		return flgCancellatoPartita;
	}

	public void setFlgCancellatoPartita(boolean flgCancellatoPartita) {
		this.flgCancellatoPartita = flgCancellatoPartita;
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public GiornataEntity getIdGiornata() {
		return idGiornata;
	}

	public void setIdGiornata(GiornataEntity idGiornata) {
		this.idGiornata = idGiornata;
	}

	public CampionatoEntity getIdCampionato() {
		return idCampionato;
	}

	public void setIdCampionato(CampionatoEntity idCampionato) {
		this.idCampionato = idCampionato;
	}

}
