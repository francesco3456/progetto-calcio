package com.calcio.apigateway.entity;


import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;


public class SquadraEntity {
	
	private Long idSquadra;
	private String nomeSquadra;
	private String nazionalitaSquadra;
	private LocalDate nascitaSquadra;
	private String stadioSquadra;
	private String cittaSquadra;
	private Blob stemma;
	private boolean flgCancellatoSquadra;
    private AllenatoreEntity allenatore;
    private List<CalciatoreEntity> calciatori;
    private String codiceSquadra;

	
	public SquadraEntity() {}

	public Long getIdSquadra() {
		return idSquadra;
	}

	public void setIdSquadra(Long idSquadra) {
		this.idSquadra = idSquadra;
	}

	public String getNomeSquadra() {
		return nomeSquadra;
	}

	public void setNomeSquadra(String nomeSquadra) {
		this.nomeSquadra = nomeSquadra;
	}

	public String getNazionalitaSquadra() {
		return nazionalitaSquadra;
	}

	public void setNazionalitaSquadra(String nazionalitaSquadra) {
		this.nazionalitaSquadra = nazionalitaSquadra;
	}

	public LocalDate getNascitaSquadra() {
		return nascitaSquadra;
	}

	public void setNascitaSquadra(LocalDate nascitaSquadra) {
		this.nascitaSquadra = nascitaSquadra;
	}

	public String getStadioSquadra() {
		return stadioSquadra;
	}

	public void setStadioSquadra(String stadioSquadra) {
		this.stadioSquadra = stadioSquadra;
	}

	public String getCittaSquadra() {
		return cittaSquadra;
	}

	public void setCittaSquadra(String cittaSquadra) {
		this.cittaSquadra = cittaSquadra;
	}

	public Blob getStemma() {
		return stemma;
	}

	public void setStemma(Blob stemma) {
		this.stemma = stemma;
	}

	public boolean isFlgCancellatoSquadra() {
		return flgCancellatoSquadra;
	}

	public void setFlgCancellatoSquadra(boolean flgCancellatoSquadra) {
		this.flgCancellatoSquadra = flgCancellatoSquadra;
	}

	public AllenatoreEntity getAllenatore() {
		return allenatore;
	}

	public void setAllenatore(AllenatoreEntity allenatore) {
		this.allenatore = allenatore;
	}

	public List<CalciatoreEntity> getCalciatori() {
		return calciatori;
	}

	public void setCalciatori(List<CalciatoreEntity> calciatori) {
		this.calciatori = calciatori;
	}

	public String getCodiceSquadra() {
		return codiceSquadra;
	}

	public void setCodiceSquadra(String codiceSquadra) {
		this.codiceSquadra = codiceSquadra;
	}
	
}

