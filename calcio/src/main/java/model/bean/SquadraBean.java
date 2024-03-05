package model.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.sql.Blob;

import model.beanInterface.InformazioniTabelle;

public class SquadraBean implements InformazioniTabelle {
	
	private Long idSquadra;
	private String nomeSquadra;
	private String nazionalitaSquadra;
	private LocalDate nascitaSquadra;
	private String stadioSquadra;
	private String cittaSquadra;
	private Blob stemmaSquadra;
	private boolean flgCancellatoSquadra;
	private LocalDateTime dataCreazioneSquadra;
	private LocalDateTime dataModificaSquadra;
	
	public SquadraBean() {}

	public SquadraBean(Long idSquadra, String nomeSquadra, String nazionalitaSquadra, LocalDate nascitaSquadra,
			String stadioSquadra, String cittaSquadra, Blob stemmaSquadra) {
		this.idSquadra = idSquadra;
		this.nomeSquadra = nomeSquadra;
		this.nazionalitaSquadra = nazionalitaSquadra;
		this.nascitaSquadra = nascitaSquadra;
		this.stadioSquadra = stadioSquadra;
		this.cittaSquadra = cittaSquadra;
		this.stemmaSquadra = stemmaSquadra;
	}

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
	
	public boolean isFlgCancellato() {
		return flgCancellatoSquadra;
	}

	public void setFlgCancellato(boolean flgCancellatoSquadra) {
		this.flgCancellatoSquadra = flgCancellatoSquadra;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneSquadra;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneSquadra) {
		this.dataCreazioneSquadra = dataCreazioneSquadra;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaSquadra;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaSquadra) {
		this.dataModificaSquadra = dataModificaSquadra;
	}

	@Override
	public String toString() {
		return "SquadraBean [idSquadra=" + idSquadra + ", nomeSquadra=" + nomeSquadra + ", nazionalitaSquadra="
				+ nazionalitaSquadra + ", nascitaSquadra=" + nascitaSquadra + ", stadioSquadra=" + stadioSquadra
				+ ", cittaSquadra=" + cittaSquadra + ", stemmaSquadra=" + stemmaSquadra + ", flgCancellatoSquadra="
				+ flgCancellatoSquadra + ", dataCreazioneSquadra=" + dataCreazioneSquadra + ", dataModificaSquadra="
				+ dataModificaSquadra + "]";
	}
	
}
