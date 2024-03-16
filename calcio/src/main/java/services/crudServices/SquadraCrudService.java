package services.crudServices;

import java.util.List;

import model.dao.crudDao.SquadraCrudDao;
import model.dto.SquadraDto;
import utils.logger.InformazioniLogger;

public class SquadraCrudService {
	
	SquadraCrudDao squadraDao = new SquadraCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<SquadraDto> findAllSquadre() {
		
		List<SquadraDto> result = squadraDao.findAll();
		
		logger.logDebug("Sto selezionando tutti le squadre: ", result);
		
		return result;
	}
	
	public SquadraDto findById(Long id) {
		
		SquadraDto result = squadraDao.findById(id);
		
		logger.logDebug("Sto selezionando la seguente squadra: ", result);
		
		return result;
	}
	
	public SquadraDto insertSquadra(SquadraDto squadra) {
		
		SquadraDto result = squadraDao.insert(squadra);
		
		logger.logDebug("Sto inserendo la seguente squadra: ", result);
		
		return result;
	}
	
	public SquadraDto updateSquadra(SquadraDto squadra) {
		
		SquadraDto result = squadraDao.update(squadra);
		
		logger.logDebug("Sto aggiornando la squadra con le seguenti informazioni ", result);
		
		return result;
	}
	
	public void deleteSquadra(Long id) {
		
		squadraDao.delete(id);
		
		logger.logDebug("Sto eliminando la squadra con il seguente ID: ", id);
	}

}
