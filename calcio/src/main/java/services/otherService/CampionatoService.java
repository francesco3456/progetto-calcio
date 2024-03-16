package services.otherService;

import java.util.List;

import model.dao.otherDao.CampionatoDao;
import utils.logger.InformazioniLogger;

public class CampionatoService {
	
	CampionatoDao campionatoDao = new CampionatoDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<String> findAllNomiCampionati() {
		
		List<String> result = campionatoDao.findAllNomiCampionati();
		
		logger.logDebug("Sto selezionando tutti i nomi dei campionati", result);
		
		return result;
	}

}
