package com.calcio.gestioneFigureCalcistiche.entities;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.calcio.gestioneFigureCalcistiche.entities.entityInterface.InformazioniTabelle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "squadra")
public class SquadraEntity implements InformazioniTabelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_squadra")
	private Long idSquadra;
	@Column(name = "nome", nullable = false, length = 100, unique = true)
	private String nomeSquadra;
	@Column(name = "nazionalità", length = 100)
	private String nazionalitaSquadra;
	@Column(name = "nascita")
	private LocalDate nascitaSquadra;
	@Column(name = "stadio", length = 100)
	private String stadioSquadra;
	@Column(name = "città", length = 100)
	private String cittaSquadra;
	@Column(name = "stemma")
	private Blob stemma;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoSquadra;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazioneSquadra;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaSquadra;
    @OneToOne(mappedBy = "idSquadra")
    private AllenatoreEntity allenatore;
    @OneToMany(mappedBy = "squadra")
    private List<CalciatoreEntity> calciatori;
    @Column(name = "cod_squadra", nullable = false, length = 3)
    private String codiceSquadra;

	
	public SquadraEntity() {}
	
	public SquadraEntity(Long idSquadra, String nomeSquadra, String nazionalitaSquadra, LocalDate nascitaSquadra,
			String stadioSquadra, String cittaSquadra, Blob stemma, boolean flgCancellatoSquadra,
			LocalDateTime dataCreazioneSquadra, LocalDateTime dataModificaSquadra, String codiceSquadra) {
		this.idSquadra = idSquadra;
		this.nomeSquadra = nomeSquadra;
		this.nazionalitaSquadra = nazionalitaSquadra;
		this.nascitaSquadra = nascitaSquadra;
		this.stadioSquadra = stadioSquadra;
		this.cittaSquadra = cittaSquadra;
		this.stemma = stemma;
		this.flgCancellatoSquadra = flgCancellatoSquadra;
		this.dataCreazioneSquadra = dataCreazioneSquadra;
		this.dataModificaSquadra = dataModificaSquadra;
		this.codiceSquadra = codiceSquadra;
	}

	public String getCodiceSquadra() {
		return codiceSquadra;
	}

	public void setCodiceSquadra(String codiceSquadra) {
		this.codiceSquadra = codiceSquadra;
	}

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

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazioneSquadra;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazioneSquadra) {
		this.dataCreazioneSquadra = dataCreazioneSquadra;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaSquadra;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaSquadra) {
		this.dataModificaSquadra = dataModificaSquadra;
	}

	@Override
	public String toString() {
		return "SquadraEntity [idSquadra=" + idSquadra + ", nomeSquadra=" + nomeSquadra + ", nazionalitaSquadra="
				+ nazionalitaSquadra + ", nascitaSquadra=" + nascitaSquadra + ", stadioSquadra=" + stadioSquadra
				+ ", cittaSquadra=" + cittaSquadra + ", stemma=" + stemma + ", flgCancellatoSquadra="
				+ flgCancellatoSquadra + ", dataCreazioneSquadra=" + dataCreazioneSquadra + ", dataModificaSquadra="
				+ dataModificaSquadra + ", codiceSquadra=" + codiceSquadra + "]";
	}

	@PrePersist
	protected void onCreate() {
	    dataCreazioneSquadra = LocalDateTime.now();
	    dataModificaSquadra = LocalDateTime.now();
	}

	
}
