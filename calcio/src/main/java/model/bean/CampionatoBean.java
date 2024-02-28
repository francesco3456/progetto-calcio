package model.bean;

import java.time.LocalDateTime;
import java.util.Date;

import com.mysql.cj.jdbc.Blob;

import model.beanInterface.InformazioniTabelle;

public class CampionatoBean implements InformazioniTabelle {
	
	private Long idCampionato;
	private String nomeCampionato;
	private String nazioneCampionato;
	private LocalDateTime inizioCampionato;
	private LocalDateTime fineCampionato;
	private Date stagioneCampionato;
	private int numeroGiornateCampionato;
	private Blob bandieraCampionato;
	private LocalDateTime dataCreazioneCampionato;
	private LocalDateTime dataModificaCampionato;
	
	public CampionatoBean() {}

	public CampionatoBean(Long idCampionato, String nomeCampionato, String nazioneCampionato,
			LocalDateTime inizioCampionato, LocalDateTime fineCampionato, Date stagioneCampionato,
			int numeroGiornateCampionato, Blob bandieraCampionato) {
		this.idCampionato = idCampionato;
		this.nomeCampionato = nomeCampionato;
		this.nazioneCampionato = nazioneCampionato;
		this.inizioCampionato = inizioCampionato;
		this.fineCampionato = fineCampionato;
		this.stagioneCampionato = stagioneCampionato;
		this.numeroGiornateCampionato = numeroGiornateCampionato;
		this.bandieraCampionato = bandieraCampionato;
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

	public Date getStagioneCampionato() {
		return stagioneCampionato;
	}

	public void setStagioneCampionato(Date stagioneCampionato) {
		this.stagioneCampionato = stagioneCampionato;
	}

	public int getNumeroGiornateCampionato() {
		return numeroGiornateCampionato;
	}

	public void setNumeroGiornateCampionato(int numeroGiornateCampionato) {
		this.numeroGiornateCampionato = numeroGiornateCampionato;
	}

	public Blob getBandieraCampionato() {
		return bandieraCampionato;
	}

	public void setBandieraCampionato(Blob bandieraCampionato) {
		this.bandieraCampionato = bandieraCampionato;
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
		return "CampionatoBean [idCampionato=" + idCampionato + ", nomeCampionato=" + nomeCampionato
				+ ", nazioneCampionato=" + nazioneCampionato + ", inizioCampionato=" + inizioCampionato
				+ ", fineCampionato=" + fineCampionato + ", stagioneCampionato=" + stagioneCampionato
				+ ", numeroGiornateCampionato=" + numeroGiornateCampionato + ", bandieraCampionato="
				+ bandieraCampionato + ", dataCreazioneCampionato=" + dataCreazioneCampionato
				+ ", dataModificaCampionato=" + dataModificaCampionato + "]";
	}


	
	
}
