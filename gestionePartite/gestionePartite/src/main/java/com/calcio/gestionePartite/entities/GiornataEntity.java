package com.calcio.gestionePartite.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.calcio.gestionePartite.entities.entityInterface.InformazioniTabelle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "giornata")
public class GiornataEntity implements InformazioniTabelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_giornata")
	private Long idGiornata;
	@Column(name = "inizio")
	private LocalDateTime inizioGiornata;
	@Column(name = "fine")
	private LocalDateTime fineGiornata;
	@Column(name = "num_giornata")
	private int numGiornata;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoGiornata;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazioneGiornata;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaGiornata;
	@OneToMany(mappedBy = "idGiornata")
	private List<PartitaEntity> partite;
	
	public GiornataEntity() {}

	public GiornataEntity(Long idGiornata, LocalDateTime inizioGiornata, LocalDateTime fineGiornata, int numGiornata,
			boolean flgCancellatoGiornata, LocalDateTime dataCreazioneGiornata, LocalDateTime dataModificaGiornata) {

		this.idGiornata = idGiornata;
		this.inizioGiornata = inizioGiornata;
		this.fineGiornata = fineGiornata;
		this.numGiornata = numGiornata;
		this.flgCancellatoGiornata = flgCancellatoGiornata;
		this.dataCreazioneGiornata = dataCreazioneGiornata;
		this.dataModificaGiornata = dataModificaGiornata;
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
		return "GiornataEntity [idGiornata=" + idGiornata + ", inizioGiornata=" + inizioGiornata + ", fineGiornata="
				+ fineGiornata + ", numGiornata=" + numGiornata + ", flgCancellatoGiornata=" + flgCancellatoGiornata
				+ ", dataCreazioneGiornata=" + dataCreazioneGiornata + ", dataModificaGiornata=" + dataModificaGiornata
				+ "]";
	}

	@PrePersist
	protected void onCreate() {
	    dataCreazioneGiornata = LocalDateTime.now();
	    dataModificaGiornata = LocalDateTime.now();
	}
}
