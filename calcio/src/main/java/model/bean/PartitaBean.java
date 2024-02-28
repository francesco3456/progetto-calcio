package model.bean;

import java.time.LocalDateTime;

import model.beanInterface.InformazioniTabelle;

public class PartitaBean implements InformazioniTabelle {

	private Long idPartita;
	private String risultatoPartita;
	private LocalDateTime dataPartita;
	private Long idGiornata;
	private Long idSquadraCasa;
	private Long idSquadraOspite;
	private LocalDateTime dataCreazionePartita;
	private LocalDateTime dataModificaPartita;
	
	public PartitaBean() {}

	public PartitaBean(Long idPartita, String risultatoPartita, LocalDateTime dataPartita, Long idGiornata,
			Long idSquadraCasa, Long idSquadraOspite) {
		this.idPartita = idPartita;
		this.risultatoPartita = risultatoPartita;
		this.dataPartita = dataPartita;
		this.idGiornata = idGiornata;
		this.idSquadraCasa = idSquadraCasa;
		this.idSquadraOspite = idSquadraOspite;
	}

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

	public Long getIdGiornata() {
		return idGiornata;
	}

	public void setIdGiornata(Long idGiornata) {
		this.idGiornata = idGiornata;
	}

	public Long getIdSquadraCasa() {
		return idSquadraCasa;
	}

	public void setIdSquadraCasa(Long idSquadraCasa) {
		this.idSquadraCasa = idSquadraCasa;
	}

	public Long getIdSquadraOspite() {
		return idSquadraOspite;
	}

	public void setIdSquadraOspite(Long idSquadraOspite) {
		this.idSquadraOspite = idSquadraOspite;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazionePartita;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazionePartita) {
		this.dataCreazionePartita = dataCreazionePartita;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaPartita;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaPartita) {
		this.dataModificaPartita = dataModificaPartita;
	}

	@Override
	public String toString() {
		return "PartitaBean [idPartita=" + idPartita + ", risultatoPartita=" + risultatoPartita + ", dataPartita="
				+ dataPartita + ", idGiornata=" + idGiornata + ", idSquadraCasa=" + idSquadraCasa + ", idSquadraOspite="
				+ idSquadraOspite + "]";
	}
	
	
}
