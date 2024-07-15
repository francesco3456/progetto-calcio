package com.calcio.apigateway.messages;

import org.springframework.stereotype.Component;

@Component
public class EsitoRicerca {
	
	private String codiceEsito;
	private String descrizioneEsito;
	
	public String getCodiceEsito() {
		return codiceEsito;
	}
	public void setCodiceEsito(String codiceEsito) {
		this.codiceEsito = codiceEsito;
	}
	public String getDescrizioneEsito() {
		return descrizioneEsito;
	}
	public void setDescrizioneEsito(String descrizioneEsito) {
		this.descrizioneEsito = descrizioneEsito;
	}
	
	

}
