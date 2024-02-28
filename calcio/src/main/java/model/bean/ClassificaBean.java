package model.bean;

import java.time.LocalDateTime;

import model.beanInterface.InformazioniTabelle;

public class ClassificaBean implements InformazioniTabelle {
	
	private Long idClassifica;
	private int puntiSquadra;
	private int goalFattiSquadra;
	private int goalSubitiSquadra;
	private int differenzaRetiSquadra;
	private int vittorieSquadra;
	private int pareggiSquadra;
	private int SconfitteSquadra;
	private Long idSquadra;
	private LocalDateTime dataCreazioneClassifica;
	private LocalDateTime dataModificaClassifica;
	
	public ClassificaBean() {}

	public ClassificaBean(Long idClassifica, int puntiSquadra, int goalFattiSquadra, int goalSubitiSquadra,
			int differenzaRetiSquadra, int vittorieSquadra, int pareggiSquadra, int sconfitteSquadra, Long idSquadra) {
		this.idClassifica = idClassifica;
		this.puntiSquadra = puntiSquadra;
		this.goalFattiSquadra = goalFattiSquadra;
		this.goalSubitiSquadra = goalSubitiSquadra;
		this.differenzaRetiSquadra = differenzaRetiSquadra;
		this.vittorieSquadra = vittorieSquadra;
		this.pareggiSquadra = pareggiSquadra;
		SconfitteSquadra = sconfitteSquadra;
		this.idSquadra = idSquadra;
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

	public int getGoalFattiSquadra() {
		return goalFattiSquadra;
	}

	public void setGoalFattiSquadra(int goalFattiSquadra) {
		this.goalFattiSquadra = goalFattiSquadra;
	}

	public int getGoalSubitiSquadra() {
		return goalSubitiSquadra;
	}

	public void setGoalSubitiSquadra(int goalSubitiSquadra) {
		this.goalSubitiSquadra = goalSubitiSquadra;
	}

	public int getDifferenzaRetiSquadra() {
		return differenzaRetiSquadra;
	}

	public void setDifferenzaRetiSquadra(int differenzaRetiSquadra) {
		this.differenzaRetiSquadra = differenzaRetiSquadra;
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
		return SconfitteSquadra;
	}

	public void setSconfitteSquadra(int sconfitteSquadra) {
		SconfitteSquadra = sconfitteSquadra;
	}

	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
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

	@Override
	public String toString() {
		return "ClassificaBean [idClassifica=" + idClassifica + ", puntiSquadra=" + puntiSquadra + ", goalFattiSquadra="
				+ goalFattiSquadra + ", goalSubitiSquadra=" + goalSubitiSquadra + ", differenzaRetiSquadra="
				+ differenzaRetiSquadra + ", vittorieSquadra=" + vittorieSquadra + ", pareggiSquadra=" + pareggiSquadra
				+ ", SconfitteSquadra=" + SconfitteSquadra + ", idSquadra=" + idSquadra + "]";
	}
	
	
}
