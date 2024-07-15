package com.calcio.gestionePartite.entities;

import java.time.LocalDateTime;

import com.calcio.gestionePartite.entities.entityInterface.InformazioniTabelle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "dettaglio_partita")
public class DettaglioPartitaEntity implements InformazioniTabelle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dettaglio")
	private Long idDettaglio;
	@Column(name = "event_gol", columnDefinition = "boolean default false")
	private boolean eventGol;
	@Column(name = "event_assist", columnDefinition = "boolean default false")
	private boolean eventAssist;
	@Column(name = "event_ammonizione", columnDefinition = "boolean default false")
	private boolean eventAmmonizione;
	@Column(name = "event_espulsione", columnDefinition = "boolean default false")
	private boolean eventEspulsione;
	@Column(name = "minuto_evento", length = 3)
	private String eventMinute;
	@Column(name = "cod_calciatore", length = 10, nullable = false)
	private String codiceCalciatore;
	@ManyToOne
	@JoinColumn(name = "id_partita", nullable = false)
	private PartitaEntity idPartita;
	@Column(name = "flg_cancellato", nullable = false, columnDefinition = "boolean default false")
	private boolean flgCancellatoPartita;
	@Column(name = "data_creazione", nullable = false)
	private LocalDateTime dataCreazione;
	@Column(name = "data_modifica", nullable = false)
	private LocalDateTime dataModifica;
	
	public DettaglioPartitaEntity () {}

	public DettaglioPartitaEntity(Long idDettaglio, boolean eventGol, boolean eventAssist, boolean eventAmmonizione,
			boolean eventEspulsione, String eventMinute, String codiceCalciatore, PartitaEntity idPartita,
			boolean flgCancellatoPartita, LocalDateTime dataCreazione, LocalDateTime dataModifica) {
		this.idDettaglio = idDettaglio;
		this.eventGol = eventGol;
		this.eventAssist = eventAssist;
		this.eventAmmonizione = eventAmmonizione;
		this.eventEspulsione = eventEspulsione;
		this.eventMinute = eventMinute;
		this.codiceCalciatore = codiceCalciatore;
		this.idPartita = idPartita;
		this.flgCancellatoPartita = flgCancellatoPartita;
		this.dataCreazione = dataCreazione;
		this.dataModifica = dataModifica;
	}

	public Long getIdDettaglio() {
		return idDettaglio;
	}

	public void setIdDettaglio(Long idDettaglio) {
		this.idDettaglio = idDettaglio;
	}

	public boolean isEventGol() {
		return eventGol;
	}

	public void setEventGol(boolean eventGol) {
		this.eventGol = eventGol;
	}

	public boolean isEventAssist() {
		return eventAssist;
	}

	public void setEventAssist(boolean eventAssist) {
		this.eventAssist = eventAssist;
	}

	public boolean isEventAmmonizione() {
		return eventAmmonizione;
	}

	public void setEventAmmonizione(boolean eventAmmonizione) {
		this.eventAmmonizione = eventAmmonizione;
	}

	public boolean isEventEspulsione() {
		return eventEspulsione;
	}

	public void setEventEspulsione(boolean eventEspulsione) {
		this.eventEspulsione = eventEspulsione;
	}

	public String getEventMinute() {
		return eventMinute;
	}

	public void setEventMinute(String eventMinute) {
		this.eventMinute = eventMinute;
	}

	public String getCodiceCalciatore() {
		return codiceCalciatore;
	}

	public void setCodiceCalciatore(String codiceCalciatore) {
		this.codiceCalciatore = codiceCalciatore;
	}

	public PartitaEntity getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(PartitaEntity idPartita) {
		this.idPartita = idPartita;
	}

	public boolean isFlgCancellatoPartita() {
		return flgCancellatoPartita;
	}

	public void setFlgCancellatoPartita(boolean flgCancellatoPartita) {
		this.flgCancellatoPartita = flgCancellatoPartita;
	}

	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public LocalDateTime getDataModifica() {
		return dataModifica;
	}

	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica = dataModifica;
	}

	@Override
	public String toString() {
		return "DettaglioPartitaEntity [idDettaglio=" + idDettaglio + ", eventGol=" + eventGol + ", eventAssist="
				+ eventAssist + ", eventAmmonizione=" + eventAmmonizione + ", eventEspulsione=" + eventEspulsione
				+ ", eventMinute=" + eventMinute + ", codiceCalciatore=" + codiceCalciatore + ", idPartita=" + idPartita
				+ ", flgCancellatoPartita=" + flgCancellatoPartita + ", dataCreazione=" + dataCreazione
				+ ", dataModifica=" + dataModifica + "]";
	}
	
	@PrePersist
	protected void onCreate() {
	    dataCreazione = LocalDateTime.now();
	    dataModifica = LocalDateTime.now();
	}

}
