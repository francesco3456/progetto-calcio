package com.calcio.gestionePartite.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.calcio.gestionePartite.entities.entityInterface.InformazioniTabelle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "partita")
public class PartitaEntity implements InformazioniTabelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_partita")
	private Long idPartita;
	@Column(name = "risultato", length = 3)
	private String risultatoPartita;
	@Column(name = "data_partita")
	private LocalDateTime dataPartita;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoPartita;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazionePartita;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModificaPartita;
	@Column(name = "squadra_casa", nullable = false, length = 100)
	private String squadraCasa;
	@Column(name = "squadra_ospite", nullable = false, length = 100)
	private String squadraOspite;
	@ManyToOne
	@JoinColumn(name = "id_giornata", nullable = false)
	private GiornataEntity idGiornata;
	@ManyToOne
	@JoinColumn(name = "id_campionato", nullable = false)
	private CampionatoEntity idCampionato;
	@OneToMany(mappedBy = "idPartita" )
	private List<DettaglioPartitaEntity> dettagliPartite;
	
	public PartitaEntity() {}

	public PartitaEntity(Long idPartita, String risultatoPartita, LocalDateTime dataPartita,
			boolean flgCancellatoPartita, LocalDateTime dataCreazionePartita, LocalDateTime dataModificaPartita,
			String squadraCasa, String squadraOspite, GiornataEntity idGiornata, CampionatoEntity idCampionato,
			List<DettaglioPartitaEntity> dettagliPartite) {
		super();
		this.idPartita = idPartita;
		this.risultatoPartita = risultatoPartita;
		this.dataPartita = dataPartita;
		this.flgCancellatoPartita = flgCancellatoPartita;
		this.dataCreazionePartita = dataCreazionePartita;
		this.dataModificaPartita = dataModificaPartita;
		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.idGiornata = idGiornata;
		this.idCampionato = idCampionato;
		this.dettagliPartite = dettagliPartite;
	}

	public Long getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(Long idPartita) {
		this.idPartita = idPartita;
	}

	public String getRisultatoPartita() {
		return risultatoPartita;
	}

	public void setRisultatoPartita(String risultatoPartita) {
		this.risultatoPartita = risultatoPartita;
	}

	public LocalDateTime getDataPartita() {
		return dataPartita;
	}

	public void setDataPartita(LocalDateTime dataPartita) {
		this.dataPartita = dataPartita;
	}

	public boolean isFlgCancellatoPartita() {
		return flgCancellatoPartita;
	}

	public void setFlgCancellatoPartita(boolean flgCancellatoPartita) {
		this.flgCancellatoPartita = flgCancellatoPartita;
	}

	@Override
	public LocalDateTime getDataCreazione() {
		return dataCreazionePartita;
	}

	@Override
	public void setDataCreazione(LocalDateTime dataCreazionePartita) {
		this.dataCreazionePartita = dataCreazionePartita;
	}

	@Override
	public LocalDateTime getDataModifica() {
		return dataModificaPartita;
	}

	@Override
	public void setDataModifica(LocalDateTime dataModificaPartita) {
		this.dataModificaPartita = dataModificaPartita;
	}

	public String getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public GiornataEntity getIdGiornata() {
		return idGiornata;
	}

	public void setIdGiornata(GiornataEntity idGiornata) {
		this.idGiornata = idGiornata;
	}

	public CampionatoEntity getIdCampionato() {
		return idCampionato;
	}

	public void setIdCampionato(CampionatoEntity idCampionato) {
		this.idCampionato = idCampionato;
	}
	
	public List<DettaglioPartitaEntity> getDettagliPartite() {
		return dettagliPartite;
	}

	public void setDettagliPartite(List<DettaglioPartitaEntity> dettagliPartite) {
		this.dettagliPartite = dettagliPartite;
	}
	
	@Override
	public String toString() {
		return "PartitaEntity [idPartita=" + idPartita + ", risultatoPartita=" + risultatoPartita + ", dataPartita="
				+ dataPartita + ", flgCancellatoPartita=" + flgCancellatoPartita + ", dataCreazionePartita="
				+ dataCreazionePartita + ", dataModificaPartita=" + dataModificaPartita + ", squadraCasa=" + squadraCasa
				+ ", squadraOspite=" + squadraOspite + ", idGiornata=" + idGiornata + ", idCampionato=" + idCampionato
				+ ", dettagliPartite=" + dettagliPartite + "]";
	}

	@PrePersist
	protected void onCreate() {
	    dataCreazionePartita = LocalDateTime.now();
	    dataModificaPartita = LocalDateTime.now();
	}

}
