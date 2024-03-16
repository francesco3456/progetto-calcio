package services.crudServices;

import java.util.List;

import model.bean.PartitaBean;
import model.dao.crudDao.PartitaCrudDao;
import utils.logger.InformazioniLogger;

public class PartitaCrudService {
	
	PartitaCrudDao partitaDao = new PartitaCrudDao();
	InformazioniLogger logger = new InformazioniLogger();
	
	public List<PartitaBean> findAllPartite() {
		
		List<PartitaBean> result = partitaDao.findAll();
		
		logger.logDebug("Sto selezionando tutti le partite: ", result);
		
		return result;
	}
	
	public PartitaBean findById(Long id) {
		
		PartitaBean result = partitaDao.findById(id);
		
		logger.logDebug("Sto selezionando la seguente partita: ", result);
		
		return result;
	}
	
	public PartitaBean insertPartita(PartitaBean partita) {
		
		PartitaBean result = partitaDao.insert(partita);
		
		logger.logDebug("Sto inserendo la seguente partita: ", result);
		
		return result;
	}
	
	public PartitaBean updatePartita(PartitaBean partita) {
		
		PartitaBean result = partitaDao.update(partita);
		
		logger.logDebug("Sto aggiornando la partita con le seguenti informazioni: ", result);
		
		return result;
	}
	
	public void deletePartita(Long id) {
		
		partitaDao.delete(id);
		
		logger.logDebug("Sto eliminando la partita con il seguente ID: ", id);
	}

}
