package services.otherService;

import java.util.List;

import model.dao.otherDao.ClassificaDao;
import utils.logger.InformazioniLogger;

public class ClassificaService {
	
	ClassificaDao punteggio = new ClassificaDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<Object> visualizzaClassifica(String nazionalita) {
		
		List<Object> result = punteggio.visualizzaClassifica(nazionalita);
		
		logger.logDebug("Sto visualizzando la classifica del campionato", result);
		
		return result;
	}

}
