package model.bean;

import java.time.LocalDateTime;

import model.beanInterface.InformazioniTabelle;

public class GiornataBean implements InformazioniTabelle {
	
	private Long idGiornata;
	private LocalDateTime inizioGiornata;
	private LocalDateTime fineGiornata;
	private LocalDateTime dataCreazioneGiornata;
	private LocalDateTime dataModificaGiornata;
	
	public GiornataBean() {}

	public GiornataBean(Long idGiornata, LocalDateTime inizioGiornata, LocalDateTime fineGiornata) {
		this.idGiornata = idGiornata;
		this.inizioGiornata = inizioGiornata;
		this.fineGiornata = fineGiornata;
	}

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
	
	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneGiornata;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneGiornata) {
		this.dataCreazioneGiornata = dataCreazioneGiornata;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaGiornata;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaGiornata) {
		this.dataModificaGiornata = dataModificaGiornata;
	}

	@Override
	public String toString() {
		return "GiornataBean [idGiornata=" + idGiornata + ", inizioGiornata=" + inizioGiornata + ", fineGiornata="
				+ fineGiornata + "]";
	}
	
	
}
