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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "allenatore")
public class AllenatoreEntity implements InformazioniTabelle, Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_allenatore")
	private Long idAllenatore;
	@OneToOne
	@JoinColumn(name = "id_squadra")
	private SquadraEntity idSquadra;
	@Column(name = "nome", length = 50)
	private String nomeAllenatore;
	@Column(name = "cognome", nullable = false, length = 70)
	private String cognomeAllenatore;
	@Column(name = "età")
	private int etaAllenatore;
	@Column(name = "nazionalità", length = 100)
	private String nazionalitaAllenatore;
	@Column(name = "altezza")
	private double altezzaAllenatore;
	@Column(name = "peso")
	private int pesoAllenatore;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoAllenatore;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazioneAllenatore;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaAllenatore;
	
	public AllenatoreEntity() {}



	public AllenatoreEntity(Long idAllenatore, SquadraEntity idSquadra, String nomeAllenatore, String cognomeAllenatore,
			int etaAllenatore, String nazionalitaAllenatore, double altezzaAllenatore, int pesoAllenatore,
			boolean flgCancellatoAllenatore, LocalDateTime dataCreazioneAllenatore,
			LocalDateTime dataModificaAllenatore) {

		this.idAllenatore = idAllenatore;
		this.idSquadra = idSquadra;
		this.nomeAllenatore = nomeAllenatore;
		this.cognomeAllenatore = cognomeAllenatore;
		this.etaAllenatore = etaAllenatore;
		this.nazionalitaAllenatore = nazionalitaAllenatore;
		this.altezzaAllenatore = altezzaAllenatore;
		this.pesoAllenatore = pesoAllenatore;
		this.flgCancellatoAllenatore = flgCancellatoAllenatore;
		this.dataCreazioneAllenatore = dataCreazioneAllenatore;
		this.dataModificaAllenatore = dataModificaAllenatore;
	}



	public Long getIdAllenatore() {
		return idAllenatore;
	}

	public void setIdAllenatore(Long idAllenatore) {
		this.idAllenatore = idAllenatore;
	}

	public SquadraEntity getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(SquadraEntity idSquadra) {
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
	
	@PrePersist
	protected void onCreate() {
	    dataCreazioneAllenatore = LocalDateTime.now();
	    dataModificaAllenatore = LocalDateTime.now();
	}

}
