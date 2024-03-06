package services.otherService;

import java.util.List;

import model.dao.otherDao.PartitaDao;
import model.dto.PartitaDto;
import utils.logger.InformazioniLogger;

public class PartitaService {

	PartitaDao partitaDao = new PartitaDao();
	InformazioniLogger logger = new InformazioniLogger();

	public List<PartitaDto> findMatchDay() {

		List<PartitaDto> result = partitaDao.findMatchDay();
		
		logger.getLogDebug("Sto selezionando le partite di oggi");

		return result;

	}
	
	public List<PartitaDto> findMatchYesterDay() {

		List<PartitaDto> result = partitaDao.findMatchYesterDay();
		
		logger.getLogDebug("Sto selezionando le partite di oggi");

		return result;

	}
	
	public List<PartitaDto> findMatchTomorrow() {

		List<PartitaDto> result = partitaDao.findMatchTomorrow();
		
		logger.getLogDebug("Sto selezionando le partite di oggi");

		return result;

	}
}
