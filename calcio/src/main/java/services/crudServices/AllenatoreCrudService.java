package services.crudServices;

import java.util.List;

import model.dao.crudDao.AllenatoreCrudDao;
import model.dto.AllenatoreDto;
import utils.logger.InformazioniLogger;

public class AllenatoreCrudService {
	
	AllenatoreCrudDao allenatoreDao = new AllenatoreCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	
	
	public List<AllenatoreDto> findAllAllenatori() {
		
		List<AllenatoreDto> result = allenatoreDao.findAll();
		
		logger.logDebug("Sto selezionando tutti gli allenatori: ", result);
		
		return result;
		
	}
	
	public AllenatoreDto findById(Long id) {
		
		AllenatoreDto result = allenatoreDao.findById(id);
		
		logger.logDebug("Sto selezionando il seguente allenatore: ", result);
		
		return result;
	}
	
	public AllenatoreDto updateAllenatore(AllenatoreDto allenatore) {
		
		AllenatoreDto result = allenatoreDao.update(allenatore);
		
		logger.logDebug("Sto aggiornando l'allenatore con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public AllenatoreDto insertAllenatore(AllenatoreDto allenatore) {
		
		AllenatoreDto result = allenatoreDao.insert(allenatore);
		
		logger.logDebug("Sto inserendo il seguente allenatore ", result);
		
		return result;
	}
	
	public void deleteAllenatore(Long id) {
		
		allenatoreDao.delete(id);
		
		logger.logDebug("Sto eliminando l'allenatore con il seguente ID: ", id);
	}

}
