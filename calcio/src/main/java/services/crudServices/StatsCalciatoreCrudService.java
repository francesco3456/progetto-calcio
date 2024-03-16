package services.crudServices;

import java.util.List;

import model.dao.crudDao.StatsCrudDao;
import model.dto.StatsCalciatoreDto;
import utils.logger.InformazioniLogger;

public class StatsCalciatoreCrudService {
	
	StatsCrudDao statsDao = new StatsCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<StatsCalciatoreDto> findAllStats() {
		
		List<StatsCalciatoreDto> result = statsDao.findAll();
		
		logger.logDebug("Sto selezionando le stats di tutti i calciatori: ", result);
		
		return result;
	}
	
	public StatsCalciatoreDto findById(Long id) {
		
		StatsCalciatoreDto result = statsDao.findById(id);
		
		logger.logDebug("Sto selezionando le stats del seguente calciatore: ", result);
		
		return result;
	}
	
	public StatsCalciatoreDto insertStats(StatsCalciatoreDto statsCalciatore) {
		
		StatsCalciatoreDto result = statsDao.insert(statsCalciatore);
		
		logger.logDebug("Sto inserendo le stats del seguente calciatore: ", result);
		
		return result;
	}
	
	public StatsCalciatoreDto updateStats(StatsCalciatoreDto statsCalciatore) {
		
		StatsCalciatoreDto result = statsDao.update(statsCalciatore);
		
		logger.logDebug("Sto aggiornando le stats del calciatore con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public void deleteStats(Long id) {
		
		statsDao.delete(id);
		
		logger.logDebug("Sto eliminando le stats del calciatore con il seguente ID: ", id);
	}

}
