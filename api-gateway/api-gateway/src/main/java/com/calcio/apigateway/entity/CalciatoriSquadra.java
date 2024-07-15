package com.calcio.apigateway.entity;

	public class CalciatoriSquadra {
	    private StatsCalciatoreEntity stats;
	    private CalciatoreEntity calciatori;

	    public CalciatoriSquadra(StatsCalciatoreEntity stats, CalciatoreEntity calciatori) {
	        this.stats = stats;
	        this.calciatori = calciatori;
	    }


	public StatsCalciatoreEntity getStats() {
		return stats;
	}

	public void setStats(StatsCalciatoreEntity stats) {
		this.stats = stats;
	}

	public CalciatoreEntity getCalciatori() {
		return calciatori;
	}

	public void setCalciatori(CalciatoreEntity calciatori) {
		this.calciatori = calciatori;
	}
	
	

}
