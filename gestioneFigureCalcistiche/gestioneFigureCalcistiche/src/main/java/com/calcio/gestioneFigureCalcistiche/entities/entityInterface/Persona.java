package com.calcio.gestioneFigureCalcistiche.entities.entityInterface;

import org.springframework.stereotype.Component;

@Component
public interface Persona {
	
	public String getNome();
	public void setNome(String nome);
	
	public String getCognome();
	public void setCognome(String cognome);
	
	public int getEta();
	public void setEta(int eta);
	
	public String getNazionalita();
	public void setNazionalita(String nazionalita);
	
	public double getAltezza();
	public void setAltezza(double altezza);
	
	public int getPeso();
	public void setPeso(int peso);


}
