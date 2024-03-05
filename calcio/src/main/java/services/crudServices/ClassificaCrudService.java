package services.crudServices;

import java.util.List;

import model.dao.crudDao.ClassificaCrudDao;
import model.dto.ClassificaDto;
import utils.logger.InformazioniLogger;

public class ClassificaCrudService {
	
	ClassificaCrudDao classificaDao = new ClassificaCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<ClassificaDto> findAllPunteggi() {
		
		List<ClassificaDto> result = classificaDao.findAll();
		
		logger.getLogDebug("Sto selezionando tutti i punteggi: ", result);
		
		return result;
	}
	
	public ClassificaDto findById(Long id) {
		
		ClassificaDto result = classificaDao.findById(id);
		
		logger.getLogDebug("Sto selezionando il seguente punteggio: ", result);
		
		return result;
	}
	
	public ClassificaDto insertPunteggio(ClassificaDto punteggio) {
		
		ClassificaDto result = classificaDao.insert(punteggio);
		
		logger.getLogDebug("Sto inserendo il seguente punteggio: ", result);
		
		return result;
	}
	
	public ClassificaDto updatePunteggio(ClassificaDto classifica) {
		
		ClassificaDto result = classificaDao.update(classifica);
		
		logger.getLogDebug("Sto aggiornando il punteggio con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public void deletePunteggio(Long id) {
		
		classificaDao.delete(id);
		
		logger.getLogDebug("Sto eliminando il punteggio con il seguente ID: ", id);
	}

}
