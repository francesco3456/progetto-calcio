package com.calcio.apigateway.entity;

public class Punteggi {
	
	  private ClassificaEntity classifica;
	    private SquadraEntity squadra;

	    // Costruttore
	    public Punteggi() {}
	    
	    public Punteggi(ClassificaEntity classifica, SquadraEntity squadra) {
	        this.classifica = classifica;
	        this.squadra = squadra;
	    }

	    // Getter e Setter
	    public ClassificaEntity getClassifica() {
	        return classifica;
	    }

	    public void setClassifica(ClassificaEntity classifica) {
	        this.classifica = classifica;
	    }

	    public SquadraEntity getSquadra() {
	        return squadra;
	    }

	    public void setSquadra(SquadraEntity squadra) {
	        this.squadra = squadra;
	    }

}

