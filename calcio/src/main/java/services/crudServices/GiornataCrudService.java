package services.crudServices;

import java.util.List;

import model.dao.crudDao.GiornataCrudDao;
import model.dto.GiornataDto;
import utils.logger.InformazioniLogger;

public class GiornataCrudService {
	
	GiornataCrudDao giornataDao = new GiornataCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<GiornataDto> findAllGiornate() {
		
		List<GiornataDto> result = giornataDao.findAll();
		
		logger.getLogDebug("Sto selezionando tutte le giornate: ", result);
		
		return result;
	}
	
	public GiornataDto findById(Long id) {
		
		GiornataDto result = giornataDao.findById(id);
		
		logger.getLogDebug("Sto selezionando la seguente giornata: ", result);
		
		return result;
	}
	
	public GiornataDto insertGiornata() {
		
		GiornataDto result = giornataDao.insert();
		
		logger.getLogDebug("Sto inserendo la seguente giornata: ", result);
		
		return result;
	}
	
	public GiornataDto updateGiornata(Long id) {
		
		GiornataDto result = giornataDao.update(id);
		
		logger.getLogDebug("Sto aggiornando la giornata con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public void deleteGiornata(Long id) {
		
		giornataDao.delete(id);
		
		logger.getLogDebug("Sto eliminando la giornata con il seguente ID: ", id);
	}

}
