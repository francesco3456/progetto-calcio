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
@Table(name = "classifica")
public class ClassificaEntity implements InformazioniTabelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_classifica")
	private Long idClassifica;
	@Column(name = "punti", columnDefinition = "int default 0")
	private int puntiSquadra;
	@Column(name = "win", columnDefinition = "int default 0")
	private int vittorieSquadra;
	@Column(name = "pari", columnDefinition = "int default 0")
	private int pareggiSquadra;
	@Column(name = "lose", columnDefinition = "int default 0")
	private int sconfitteSquadra;
	@Column(name = "gol_fatti", columnDefinition = "int default 0")
	private int golFattiSquadra;
	@Column(name = "gol_subiti", columnDefinition = "int default 0") 
	private int golSubitiSquadra;
	@Column(name = "differenza_reti", columnDefinition = "int default 0")
	private int differenzaRetiSquadra;
	@Column(name = "squadra", length = 50, nullable = false)
	private String codiceSquadra;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoClassifica;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazioneClassifica;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaClassifica;
	@Column(name = "nazione", nullable = false, length = 100)
	private String nazioneSquadra;
	
	public ClassificaEntity() {}


	public ClassificaEntity(Long idClassifica, int puntiSquadra, int vittorieSquadra, int pareggiSquadra,
			int sconfitteSquadra, int golFattiSquadra, int golSubitiSquadra, int differenzaRetiSquadra,
			String codiceSquadra, boolean flgCancellatoClassifica, LocalDateTime dataCreazioneClassifica,
			LocalDateTime dataModificaClassifica, String nazioneSquadra) {
		this.idClassifica = idClassifica;
		this.puntiSquadra = puntiSquadra;
		this.vittorieSquadra = vittorieSquadra;
		this.pareggiSquadra = pareggiSquadra;
		this.sconfitteSquadra = sconfitteSquadra;
		this.golFattiSquadra = golFattiSquadra;
		this.golSubitiSquadra = golSubitiSquadra;
		this.differenzaRetiSquadra = differenzaRetiSquadra;
		this.codiceSquadra = codiceSquadra;
		this.flgCancellatoClassifica = flgCancellatoClassifica;
		this.dataCreazioneClassifica = dataCreazioneClassifica;
		this.dataModificaClassifica = dataModificaClassifica;
		this.nazioneSquadra = nazioneSquadra;
	}


	public Long getIdClassifica() {
		return idClassifica;
	}

	public void setIdClassifica(Long idClassifica) {
		this.idClassifica = idClassifica;
	}

	public int getPuntiSquadra() {
		return puntiSquadra;
	}

	public void setPuntiSquadra(int puntiSquadra) {
		this.puntiSquadra = puntiSquadra;
	}

	public int getVittorieSquadra() {
		return vittorieSquadra;
	}

	public void setVittorieSquadra(int vittorieSquadra) {
		this.vittorieSquadra = vittorieSquadra;
	}

	public int getPareggiSquadra() {
		return pareggiSquadra;
	}

	public void setPareggiSquadra(int pareggiSquadra) {
		this.pareggiSquadra = pareggiSquadra;
	}

	public int getSconfitteSquadra() {
		return sconfitteSquadra;
	}

	public void setSconfitteSquadra(int sconfitteSquadra) {
		this.sconfitteSquadra = sconfitteSquadra;
	}

	public int getGolFattiSquadra() {
		return golFattiSquadra;
	}

	public void setGolFattiSquadra(int golFattiSquadra) {
		this.golFattiSquadra = golFattiSquadra;
	}

	public int getGolSubitiSquadra() {
		return golSubitiSquadra;
	}

	public void setGolSubitiSquadra(int golSubitiSquadra) {
		this.golSubitiSquadra = golSubitiSquadra;
	}

	public int getDifferenzaRetiSquadra() {
		return differenzaRetiSquadra;
	}

	public void setDifferenzaRetiSquadra(int differenzaRetiSquadra) {
		this.differenzaRetiSquadra = differenzaRetiSquadra;
	}

	public String getCodiceSquadra() {
		return codiceSquadra;
	}

	public void setCodiceSquadra(String codiceSquadra) {
		this.codiceSquadra = codiceSquadra;
	}

	public boolean isFlgCancellatoClassifica() {
		return flgCancellatoClassifica;
	}

	public void setFlgCancellatoClassifica(boolean flgCancellatoClassifica) {
		this.flgCancellatoClassifica = flgCancellatoClassifica;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneClassifica;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneClassifica) {
		this.dataCreazioneClassifica = dataCreazioneClassifica;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaClassifica;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaClassifica) {
		this.dataModificaClassifica = dataModificaClassifica;
	}
	
	public String getNazioneSquadra() {
		return nazioneSquadra;
	}


	public void setNazioneSquadra(String nazioneSquadra) {
		this.nazioneSquadra = nazioneSquadra;
	}

	@Override
	public String toString() {
		return "ClassificaEntity [idClassifica=" + idClassifica + ", puntiSquadra=" + puntiSquadra
				+ ", vittorieSquadra=" + vittorieSquadra + ", pareggiSquadra=" + pareggiSquadra + ", sconfitteSquadra="
				+ sconfitteSquadra + ", golFattiSquadra=" + golFattiSquadra + ", golSubitiSquadra=" + golSubitiSquadra
				+ ", differenzaRetiSquadra=" + differenzaRetiSquadra + ", codiceSquadra=" + codiceSquadra
				+ ", flgCancellatoClassifica=" + flgCancellatoClassifica + ", dataCreazioneClassifica="
				+ dataCreazioneClassifica + ", dataModificaClassifica=" + dataModificaClassifica + ", nazioneSquadra="
				+ nazioneSquadra + "]";
	}


	@PrePersist
	protected void onCreate() {
	    dataCreazioneClassifica = LocalDateTime.now();
	    dataModificaClassifica = LocalDateTime.now();
	}
}
