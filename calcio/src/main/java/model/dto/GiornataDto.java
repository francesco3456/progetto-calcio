package model.dto;

import java.time.LocalDateTime;

public class GiornataDto {
	
	private Long idGiornata;
	private LocalDateTime inizioGiornata;
	private LocalDateTime fineGiornata;
	
	public GiornataDto() {}
	
	public Long getIdGiornata() {
		return idGiornata;
	}

	public void setIdGiornata(Long idGiornata) {
		this.idGiornata = idGiornata;
	}

	public LocalDateTime getInizioGiornata() {
		return inizioGiornata;
	}

	public void setInizioGiornata(LocalDateTime inizioGiornata) {
		this.inizioGiornata = inizioGiornata;
	}

	public LocalDateTime getFineGiornata() {
		return fineGiornata;
	}

	public void setFineGiornata(LocalDateTime fineGiornata) {
		this.fineGiornata = fineGiornata;
	}

	@Override
	public String toString() {
		return "GiornataBean [idGiornata=" + idGiornata + ", inizioGiornata=" + inizioGiornata + ", fineGiornata="
				+ fineGiornata + "]";
	}
	

}
