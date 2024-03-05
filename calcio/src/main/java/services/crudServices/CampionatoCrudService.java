package services.crudServices;

import java.util.List;

import model.bean.CampionatoBean;
import model.dao.crudDao.CampionatoCrudDao;
import utils.logger.InformazioniLogger;

public class CampionatoCrudService {
	
	CampionatoCrudDao campionatoDao = new CampionatoCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<CampionatoBean> findAllCampionati() {
		
		List<CampionatoBean> result = campionatoDao.findAll();
		
		logger.getLogDebug("Sto selezionando tutti i campionati: ", result);
		
		return result;
	}
	
	public CampionatoBean findById(Long id) {
		
		CampionatoBean result = campionatoDao.findById(id);
		
		logger.getLogDebug("Sto selezionando il seguente campionato: ", result);
		
		return result;
	}
	
	public CampionatoBean insertCampionato(CampionatoBean campionato) {
		
		CampionatoBean result = campionatoDao.insert(campionato);
		
		logger.getLogDebug("Sto inserendo il seguente campionato: ", result);
		
		return result;
	}
	
	public CampionatoBean updateCampionato(CampionatoBean campionato) {
		
		CampionatoBean result = campionatoDao.update(campionato);
		
		logger.getLogDebug("Sto aggiornando il campionato con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public void deleteCampionato(Long id) {
		
		campionatoDao.delete(id);
		
		logger.getLogDebug("Sto eliminando il campionato con il seguente ID: ", id);
	}

}
