package model.dto;

public class StatsCalciatoreDto {
	
	private Long idStatsCalciatore;
	private int golCalciatore;
	private int assistCalciatore;
	private Long idCalciatore;
	
	public StatsCalciatoreDto() {}
	
	public Long getIdStatsCalciatore() {
		return idStatsCalciatore;
	}

	public void setIdStatsCalciatore(Long idStatsCalciatore) {
		this.idStatsCalciatore = idStatsCalciatore;
	}

	public int getGolCalciatore() {
		return golCalciatore;
	}

	public void setGolCalciatore(int golCalciatore) {
		this.golCalciatore = golCalciatore;
	}

	public int getAssistCalciatore() {
		return assistCalciatore;
	}

	public void setAssistCalciatore(int assistCalciatore) {
		this.assistCalciatore = assistCalciatore;
	}

	public Long getIdCalciatore() {
		return idCalciatore;
	}

	public void setIdCalciatore(Long idCalciatore) {
		this.idCalciatore = idCalciatore;
	}

	@Override
	public String toString() {
		return "StatsCalciatoreBean [idStatsCalciatore=" + idStatsCalciatore + ", golCalciatore=" + golCalciatore
				+ ", assistCalciatore=" + assistCalciatore + ", idCalciatore=" + idCalciatore + "]";
	}
	

}
