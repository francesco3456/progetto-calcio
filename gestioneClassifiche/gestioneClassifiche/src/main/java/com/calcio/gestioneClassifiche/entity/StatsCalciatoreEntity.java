package com.calcio.gestioneClassifiche.entity;

import java.time.LocalDateTime;

import com.calcio.gestioneClassifiche.entity.entityInterface.InformazioniTabelle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "statsCalciatore")
public class StatsCalciatoreEntity implements InformazioniTabelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stats_calciatore")
	private Long idStatsCalciatore;
	@Column(name = "gol", columnDefinition = "int default 0")
	private int golCalciatore;
	@Column(name = "assist", columnDefinition = "int default 0")
	private int assistCalciatore;
	@Column(name = "calciatore", nullable = false, length = 150)
	private String calciatore;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoStatsCalciatore;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazioneStatsCalciatore;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaStatsCalciatore;
	@Column(name = "nazione", nullable = false, length = 100)
	private String nazioneSquadra;
	
	public StatsCalciatoreEntity() {}

	public Long getIdStatsCalciatore() {
		return idStatsCalciatore;
	}

	public void setIdStatsCalciatore(Long idStatsCalciatore) {
		this.idStatsCalciatore = idStatsCalciatore;
	}

	public int getGolCalciatore() {
		return golCalciatore;
	}

	public void setGolCalciatore(int golCalciatore) {
		this.golCalciatore = golCalciatore;
	}

	public int getAssistCalciatore() {
		return assistCalciatore;
	}

	public void setAssistCalciatore(int assistCalciatore) {
		this.assistCalciatore = assistCalciatore;
	}

	public String getCalciatore() {
		return calciatore;
	}

	public void setCalciatore(String calciatore) {
		this.calciatore = calciatore;
	}

	public boolean isFlgCancellatoStatsCalciatore() {
		return flgCancellatoStatsCalciatore;
	}

	public void setFlgCancellatoStatsCalciatore(boolean flgCancellatoStatsCalciatore) {
		this.flgCancellatoStatsCalciatore = flgCancellatoStatsCalciatore;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneStatsCalciatore;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneStatsCalciatore) {
		this.dataCreazioneStatsCalciatore = dataCreazioneStatsCalciatore;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaStatsCalciatore;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaStatsCalciatore) {
		this.dataModificaStatsCalciatore = dataModificaStatsCalciatore;
	}

	public String getNazioneSquadra() {
		return nazioneSquadra;
	}

	public void setNazioneSquadra(String nazioneSquadra) {
		this.nazioneSquadra = nazioneSquadra;
	}
	
	@Override
	public String toString() {
		return "StatsCalciatoreEntity [idStatsCalciatore=" + idStatsCalciatore + ", golCalciatore=" + golCalciatore
				+ ", assistCalciatore=" + assistCalciatore + ", calciatore=" + calciatore
				+ ", flgCancellatoStatsCalciatore=" + flgCancellatoStatsCalciatore + ", dataCreazioneStatsCalciatore="
				+ dataCreazioneStatsCalciatore + ", dataModificaStatsCalciatore=" + dataModificaStatsCalciatore
				+ ", nazioneSquadra=" + nazioneSquadra + "]";
	}

	@PrePersist
	protected void onCreate() {
	    dataCreazioneStatsCalciatore = LocalDateTime.now();
	    dataModificaStatsCalciatore = LocalDateTime.now();
	}

}
