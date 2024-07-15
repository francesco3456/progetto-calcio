package com.calcio.gestionePartite.entities;

import java.sql.Blob;
import java.time.LocalDate;
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
@Table(name = "campionato")
public class CampionatoEntity implements InformazioniTabelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_campionato")
	private Long idCampionato;
	@Column(name = "nome", length = 70, nullable = false)
	private String nomeCampionato;
	@Column(name = "nazione", length = 100, nullable = false)
	private String nazioneCampionato;
	@Column(name = "inizio")
	private LocalDateTime inizioCampionato;
	@Column(name = "fine")
	private LocalDateTime fineCampionato;
	@Column(name = "stagione", nullable = false)
	private LocalDate stagioneCampionato;
	@Column(name = "tot_giornate")
	private int totGiornateCampionato;
	@Column(name = "bandiera")
	private Blob bandieraCampionato;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoCampionato;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazioneCampionato;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaCampionato;
	@OneToMany(mappedBy = "idCampionato")
	private List<PartitaEntity> partite;
	
	public CampionatoEntity() {}

	public CampionatoEntity(Long idCampionato, String nomeCampionato, String nazioneCampionato,
			LocalDateTime inizioCampionato, LocalDateTime fineCampionato, LocalDate stagioneCampionato,
			int totGiornateCampionato, Blob bandieraCampionato, boolean flgCancellatoCampionato,
			LocalDateTime dataCreazioneCampionato, LocalDateTime dataModificaCampionato) {

		this.idCampionato = idCampionato;
		this.nomeCampionato = nomeCampionato;
		this.nazioneCampionato = nazioneCampionato;
		this.inizioCampionato = inizioCampionato;
		this.fineCampionato = fineCampionato;
		this.stagioneCampionato = stagioneCampionato;
		this.totGiornateCampionato = totGiornateCampionato;
		this.bandieraCampionato = bandieraCampionato;
		this.flgCancellatoCampionato = flgCancellatoCampionato;
		this.dataCreazioneCampionato = dataCreazioneCampionato;
		this.dataModificaCampionato = dataModificaCampionato;
	}

	public Long getIdCampionato() {
		return idCampionato;
	}

	public void setIdCampionato(Long idCampionato) {
		this.idCampionato = idCampionato;
	}

	public String getNomeCampionato() {
		return nomeCampionato;
	}

	public void setNomeCampionato(String nomeCampionato) {
		this.nomeCampionato = nomeCampionato;
	}

	public String getNazioneCampionato() {
		return nazioneCampionato;
	}

	public void setNazioneCampionato(String nazioneCampionato) {
		this.nazioneCampionato = nazioneCampionato;
	}

	public LocalDateTime getInizioCampionato() {
		return inizioCampionato;
	}

	public void setInizioCampionato(LocalDateTime inizioCampionato) {
		this.inizioCampionato = inizioCampionato;
	}

	public LocalDateTime getFineCampionato() {
		return fineCampionato;
	}

	public void setFineCampionato(LocalDateTime fineCampionato) {
		this.fineCampionato = fineCampionato;
	}

	public LocalDate getStagioneCampionato() {
		return stagioneCampionato;
	}

	public void setStagioneCampionato(LocalDate stagioneCampionato) {
		this.stagioneCampionato = stagioneCampionato;
	}

	public int getTotGiornateCampionato() {
		return totGiornateCampionato;
	}

	public void setTotGiornateCampionato(int totGiornateCampionato) {
		this.totGiornateCampionato = totGiornateCampionato;
	}

	public Blob getBandieraCampionato() {
		return bandieraCampionato;
	}

	public void setBandieraCampionato(Blob bandieraCampionato) {
		this.bandieraCampionato = bandieraCampionato;
	}

	public boolean isFlgCancellatoCampionato() {
		return flgCancellatoCampionato;
	}

	public void setFlgCancellatoCampionato(boolean flgCancellatoCampionato) {
		this.flgCancellatoCampionato = flgCancellatoCampionato;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneCampionato;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneCampionato) {
		this.dataCreazioneCampionato = dataCreazioneCampionato;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaCampionato;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaCampionato) {
		this.dataModificaCampionato = dataModificaCampionato;
	}

	@Override
	public String toString() {
		return "CampionatoEntity [idCampionato=" + idCampionato + ", nomeCampionato=" + nomeCampionato
				+ ", nazioneCampionato=" + nazioneCampionato + ", inizioCampionato=" + inizioCampionato
				+ ", fineCampionato=" + fineCampionato + ", stagioneCampionato=" + stagioneCampionato
				+ ", totGiornateCampionato=" + totGiornateCampionato + ", bandieraCampionato=" + bandieraCampionato
				+ ", flgCancellatoCampionato=" + flgCancellatoCampionato + ", dataCreazioneCampionato="
				+ dataCreazioneCampionato + ", dataModificaCampionato=" + dataModificaCampionato + "]";
	}

	@PrePersist
	protected void onCreate() {
	    dataCreazioneCampionato = LocalDateTime.now();
	    dataModificaCampionato = LocalDateTime.now();
	}
}
