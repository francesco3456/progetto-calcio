package model.dto;

import java.time.LocalDateTime;

public class PartitaDto {
	
	private Long idPartita;
	private String risultatoPartita;
	private LocalDateTime dataPartita;
	private Long idGiornata;
	private Long idSquadraCasa;
	private Long idSquadraOspite;
	
	public PartitaDto() {}
	
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

	public Long getIdGiornata() {
		return idGiornata;
	}

	public void setIdGiornata(Long idGiornata) {
		this.idGiornata = idGiornata;
	}

	public Long getIdSquadraCasa() {
		return idSquadraCasa;
	}

	public void setIdSquadraCasa(Long idSquadraCasa) {
		this.idSquadraCasa = idSquadraCasa;
	}

	public Long getIdSquadraOspite() {
		return idSquadraOspite;
	}

	public void setIdSquadraOspite(Long idSquadraOspite) {
		this.idSquadraOspite = idSquadraOspite;
	}

	@Override
	public String toString() {
		return "PartitaBean [idPartita=" + idPartita + ", risultatoPartita=" + risultatoPartita + ", dataPartita="
				+ dataPartita + ", idGiornata=" + idGiornata + ", idSquadraCasa=" + idSquadraCasa + ", idSquadraOspite="
				+ idSquadraOspite + "]";
	}
	

}
