package services.crudServices;

import java.util.List;

import model.dto.CalciatoreDto;
import utils.logger.InformazioniLogger;
import model.dao.crudDao.CalciatoreCrudDao;

public class CalciatoreCrudService {
	
	CalciatoreCrudDao calciatoreDao = new CalciatoreCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<CalciatoreDto> findAllCalciatori() {
		
		List<CalciatoreDto> result = calciatoreDao.findAll();
		
		logger.getLogDebug("Sto selezionando tutti i calciatori: ", result);
		
		return result;
	}
	
	public CalciatoreDto findById(Long id) {
		
		CalciatoreDto result = calciatoreDao.findById(id);
		
		logger.getLogDebug("Sto selezionando il seguente calciatore: ", result);
		
		return result;
	}
	
	public CalciatoreDto insertCalciatore() {
		
		CalciatoreDto result = calciatoreDao.insert();
		
		logger.getLogDebug("Sto inserendo il seguente calciatore: ", result);
		
		return result;
	}
	
	public CalciatoreDto updateCalciatore(Long id) {
		
		CalciatoreDto result = calciatoreDao.update(id);
		
		logger.getLogDebug("Sto aggiornando il calciatore con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public void deleteCalciatore(Long id) {
		
		calciatoreDao.delete(id);
		
		logger.getLogDebug("Sto eliminando il calciatore con il seguente ID: ", id);
	}

}
