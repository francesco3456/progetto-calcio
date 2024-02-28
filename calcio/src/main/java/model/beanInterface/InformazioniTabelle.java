package model.beanInterface;

import java.time.LocalDateTime;

public interface InformazioniTabelle {
	
	//public boolean isFlgCancellato();
	//public void setFlgCancellato(boolean flgCancellato);
	
	public LocalDateTime getDataCreazione();
	public void setDataCreazione(LocalDateTime dataCreazione);
	
	public LocalDateTime getDataModifica();
	public void setDataModifica(LocalDateTime dataModifica);

}
