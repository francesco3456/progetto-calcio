package model.dto;

import java.util.Date;

import com.mysql.cj.jdbc.Blob;

public class CampionatoDto {

	private Long idCampionato;
	private String nomeCampionato;
	private Date stagioneCampionato;
	private Blob bandieraCampionato;
	
	public CampionatoDto() {}

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

	public Date getStagioneCampionato() {
		return stagioneCampionato;
	}

	public void setStagioneCampionato(Date stagioneCampionato) {
		this.stagioneCampionato = stagioneCampionato;
	}

	public Blob getBandieraCampionato() {
		return bandieraCampionato;
	}

	public void setBandieraCampionato(Blob bandieraCampionato) {
		this.bandieraCampionato = bandieraCampionato;
	}

	@Override
	public String toString() {
		return "CampionatoDto [idCampionato=" + idCampionato + ", nomeCampionato=" + nomeCampionato
				+ ", stagioneCampionato=" + stagioneCampionato + ", bandieraCampionato=" + bandieraCampionato + "]";
	}

	
}
