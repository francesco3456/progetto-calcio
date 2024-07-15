package com.calcio.gestioneFigureCalcistiche.entities;

import java.time.LocalDateTime;

import com.calcio.gestioneFigureCalcistiche.entities.entityInterface.InformazioniTabelle;
import com.calcio.gestioneFigureCalcistiche.entities.entityInterface.Persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "calciatore")
public class CalciatoreEntity implements InformazioniTabelle, Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_calciatore")
	private Long idCalciatore;
	@ManyToOne
	@JoinColumn(name = "id_squadra")
	private SquadraEntity squadra;
	@Column(name = "ruolo", length = 5)
	private String ruoloCalciatore;
	@Column(name = "cod_calciatore", length = 10)
	private String codiceCalciatore;
	@Column(name = "nome", length = 50)
	private String nomeCalciatore;
	@Column(name = "cognome", nullable = false, length = 70)
	private String cognomeCalciatore;
	@Column(name = "età")
	private int etaCalciatore;
	@Column(name = "nazionalità", length = 100)
	private String nazionalitaCalciatore;
	@Column(name = "altezza")
	private double altezzaCalciatore;
	@Column(name = "peso")
	private int pesoCalciatore;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoCalciatore;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazioneCalciatore;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaCalciatore;
	
	public CalciatoreEntity () {}

	public CalciatoreEntity(Long idCalciatore, SquadraEntity squadra, String ruoloCalciatore, String codiceCalciatore,
			String nomeCalciatore, String cognomeCalciatore, int etaCalciatore, String nazionalitaCalciatore,
			double altezzaCalciatore, int pesoCalciatore, boolean flgCancellatoCalciatore,
			LocalDateTime dataCreazioneCalciatore, LocalDateTime dataModificaCalciatore) {
		this.idCalciatore = idCalciatore;
		this.squadra = squadra;
		this.ruoloCalciatore = ruoloCalciatore;
		this.codiceCalciatore = codiceCalciatore;
		this.nomeCalciatore = nomeCalciatore;
		this.cognomeCalciatore = cognomeCalciatore;
		this.etaCalciatore = etaCalciatore;
		this.nazionalitaCalciatore = nazionalitaCalciatore;
		this.altezzaCalciatore = altezzaCalciatore;
		this.pesoCalciatore = pesoCalciatore;
		this.flgCancellatoCalciatore = flgCancellatoCalciatore;
		this.dataCreazioneCalciatore = dataCreazioneCalciatore;
		this.dataModificaCalciatore = dataModificaCalciatore;
	}

	public String getCodiceCalciatore() {
		return codiceCalciatore;
	}

	public void setCodiceCalciatore(String codiceCalciatore) {
		this.codiceCalciatore = codiceCalciatore;
	}

	public Long getIdCalciatore() {
		return idCalciatore;
	}

	public void setIdCalciatore(Long idCalciatore) {
		this.idCalciatore = idCalciatore;
	}

	public SquadraEntity getSquadra() {
		return squadra;
	}

	public void setSquadra(SquadraEntity squadra) {
		this.squadra = squadra;
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

	public boolean isFlgCancellatoCalciatore() {
		return flgCancellatoCalciatore;
	}

	public void setFlgCancellatoCalciatore(boolean flgCancellatoCalciatore) {
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
		return "CalciatoreEntity [idCalciatore=" + idCalciatore + ", squadra=" + squadra + ", ruoloCalciatore="
				+ ruoloCalciatore + ", codiceCalciatore=" + codiceCalciatore + ", nomeCalciatore=" + nomeCalciatore
				+ ", cognomeCalciatore=" + cognomeCalciatore + ", etaCalciatore=" + etaCalciatore
				+ ", nazionalitaCalciatore=" + nazionalitaCalciatore + ", altezzaCalciatore=" + altezzaCalciatore
				+ ", pesoCalciatore=" + pesoCalciatore + ", flgCancellatoCalciatore=" + flgCancellatoCalciatore
				+ ", dataCreazioneCalciatore=" + dataCreazioneCalciatore + ", dataModificaCalciatore="
				+ dataModificaCalciatore + "]";
	}

	@PrePersist
	protected void onCreate() {
	    dataCreazioneCalciatore = LocalDateTime.now();
	    dataModificaCalciatore = LocalDateTime.now();
	}

}
