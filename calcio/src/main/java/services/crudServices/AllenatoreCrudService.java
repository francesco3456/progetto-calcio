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
		
		logger.getLogDebug("Sto selezionando tutti gli allenatori: ", result);
		
		return result;
		
	}
	
	public AllenatoreDto findById(Long id) {
		
		AllenatoreDto result = allenatoreDao.findById(id);
		
		logger.getLogDebug("Sto selezionando il seguente allenatore: ", result);
		
		return result;
	}
	
	public AllenatoreDto updateAllenatore(Long id) {
		
		AllenatoreDto result = allenatoreDao.update(id);
		
		logger.getLogDebug("Sto aggiornando l'allenatore con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public AllenatoreDto insertAllenatore() {
		
		AllenatoreDto result = allenatoreDao.insert();
		
		logger.getLogDebug("Sto inserendo il seguente allenatore ", result);
		
		return result;
	}
	
	public void deleteAllenatore(Long id) {
		
		allenatoreDao.delete(id);
		
		logger.getLogDebug("Sto eliminando l'allenatore con il seguente ID: ", id);
	}

}
