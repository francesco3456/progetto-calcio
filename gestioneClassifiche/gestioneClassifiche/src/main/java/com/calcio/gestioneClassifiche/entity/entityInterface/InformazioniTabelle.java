package com.calcio.gestioneClassifiche.entity.entityInterface;

import java.time.LocalDateTime;

public interface InformazioniTabelle {
	
	public LocalDateTime getDataCreazione();
	public void setDataCreazione(LocalDateTime dataCreazione);
	
	public LocalDateTime getDataModifica();
	public void setDataModifica(LocalDateTime dataModifica);

}
