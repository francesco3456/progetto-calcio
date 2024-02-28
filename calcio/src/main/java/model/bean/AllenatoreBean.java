package model.bean;

import java.time.LocalDateTime;

import model.beanInterface.InformazioniTabelle;
import model.beanInterface.Persona;

public class AllenatoreBean implements Persona, InformazioniTabelle {

	private Long idAllenatore;
	private Long idSquadra;
	
	private String nomeAllenatore;
	private String cognomeAllenatore;
	private int etaAllenatore;
	private String nazionalitaAllenatore;
	private double altezzaAllenatore;
	private int pesoAllenatore;
	private boolean flgCancellatoAllenatore;
	private LocalDateTime dataCreazioneAllenatore;
	private LocalDateTime dataModificaAllenatore;
	
	public AllenatoreBean() {}

	public AllenatoreBean(Long idAllenatore, Long idSquadra, String nomeAllenatore, String cognomeAllenatore,
			int etaAllenatore, String nazionalitaAllenatore, double altezzaAllenatore, int pesoAllenatore) {
		this.idAllenatore = idAllenatore;
		this.idSquadra = idSquadra;
		this.nomeAllenatore = nomeAllenatore;
		this.cognomeAllenatore = cognomeAllenatore;
		this.etaAllenatore = etaAllenatore;
		this.nazionalitaAllenatore = nazionalitaAllenatore;
		this.altezzaAllenatore = altezzaAllenatore;
		this.pesoAllenatore = pesoAllenatore;
	}

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
	
	public boolean isFlgCancellato() {
		return flgCancellatoAllenatore;
	}

	public void setFlgCancellato(boolean flgCancellatoAllenatore) {
		this.flgCancellatoAllenatore = flgCancellatoAllenatore;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneAllenatore;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneAllenatore) {
		this.dataCreazioneAllenatore = dataCreazioneAllenatore;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaAllenatore;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaAllenatore) {
		this.dataModificaAllenatore = dataModificaAllenatore;
	}

	@Override
	public String toString() {
		return "AllenatoreBean [idAllenatore=" + idAllenatore + ", idSquadra=" + idSquadra + ", nomeAllenatore="
				+ nomeAllenatore + ", cognomeAllenatore=" + cognomeAllenatore + ", etaAllenatore=" + etaAllenatore
				+ ", nazionalitaAllenatore=" + nazionalitaAllenatore + ", altezzaAllenatore=" + altezzaAllenatore
				+ ", pesoAllenatore=" + pesoAllenatore + "]";
	}
	
		
}
