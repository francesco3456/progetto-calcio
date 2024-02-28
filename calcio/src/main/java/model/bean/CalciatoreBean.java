package model.bean;

import java.time.LocalDateTime;

import model.beanInterface.InformazioniTabelle;
import model.beanInterface.Persona;

public class CalciatoreBean implements Persona, InformazioniTabelle {
	
	private Long idCalciatore;
	private Long idSquadra;
	private String ruoloCalciatore;
	
	private String nomeCalciatore;
	private String cognomeCalciatore;
	private int etaCalciatore;
	private String nazionalitaCalciatore;
	private double altezzaCalciatore;
	private int pesoCalciatore;
	
	private boolean flgCancellatoCalciatore;
	private LocalDateTime dataCreazioneCalciatore;
	private LocalDateTime dataModificaCalciatore;
	
	public CalciatoreBean () {}

	public CalciatoreBean(Long idCalciatore, Long idSquadra, String ruoloCalciatore, String nomeCalciatore,
			String cognomeCalciatore, int etaCalciatore, String nazionalitaCalciatore, double altezzaCalciatore,
			int pesoCalciatore) {
		this.idCalciatore = idCalciatore;
		this.idSquadra = idSquadra;
		this.ruoloCalciatore = ruoloCalciatore;
		this.nomeCalciatore = nomeCalciatore;
		this.cognomeCalciatore = cognomeCalciatore;
		this.etaCalciatore = etaCalciatore;
		this.nazionalitaCalciatore = nazionalitaCalciatore;
		this.altezzaCalciatore = altezzaCalciatore;
		this.pesoCalciatore = pesoCalciatore;
	}

	public Long getIdCalciatore() {
		return idCalciatore;
	}

	public void setIdCalciatore(Long idCalciatore) {
		this.idCalciatore = idCalciatore;
	}

	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
	}

	public String getRuoloCalciatore() {
		return ruoloCalciatore;
	}

	public void setRuoloCalciatore(String ruoloCalciatore) {
		this.ruoloCalciatore = ruoloCalciatore;
	}

	@Override
	public String getNome() {
		return nomeCalciatore;
	}

	@Override
	public void setNome(String nomeCalciatore) {
		this.nomeCalciatore = nomeCalciatore;
	}

	@Override
	public String getCognome() {
		return cognomeCalciatore;
	}

	@Override
	public void setCognome(String cognomeCalciatore) {
		this.cognomeCalciatore = cognomeCalciatore;
	}

	@Override
	public int getEta() {
		return etaCalciatore;
	}

	@Override
	public void setEta(int etaCalciatore) {
		this.etaCalciatore = etaCalciatore;
	}

	@Override
	public String getNazionalita() {
		return nazionalitaCalciatore;
	}

	@Override
	public void setNazionalita(String nazionalitaCalciatore) {
		this.nazionalitaCalciatore = nazionalitaCalciatore;
	}

	@Override
	public double getAltezza() {
		return altezzaCalciatore;
	}

	@Override
	public void setAltezza(double altezzaCalciatore) {
		this.altezzaCalciatore = altezzaCalciatore;
	}

	@Override
	public int getPeso() {
		return pesoCalciatore;
	}

	@Override
	public void setPeso(int pesoCalciatore) {
		this.pesoCalciatore = pesoCalciatore;
	}

	public boolean isFlgCancellato() {
		return flgCancellatoCalciatore;
	}

	public void setFlgCancellato(boolean flgCancellatoCalciatore) {
		this.flgCancellatoCalciatore = flgCancellatoCalciatore;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneCalciatore;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneCalciatore) {
		this.dataCreazioneCalciatore = dataCreazioneCalciatore;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaCalciatore;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaCalciatore) {
		this.dataModificaCalciatore = dataModificaCalciatore;
	}

	
	@Override
	public String toString() {
		return "CalciatoreBean [idCalciatore=" + idCalciatore + ", idSquadra=" + idSquadra + ", ruoloCalciatore="
				+ ruoloCalciatore + ", nomeCalciatore=" + nomeCalciatore + ", cognomeCalciatore=" + cognomeCalciatore
				+ ", etaCalciatore=" + etaCalciatore + ", nazionalitaCalciatore=" + nazionalitaCalciatore
				+ ", altezzaCalciatore=" + altezzaCalciatore + ", pesoCalciatore=" + pesoCalciatore + "]";
	}
	
	
	
	

}
