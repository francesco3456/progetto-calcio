package services.crudServices;

import java.util.List;

import model.bean.GiornataBean;
import model.dao.crudDao.GiornataCrudDao;

public class GiornataCrudService {
	
	GiornataCrudDao giornataDao = new GiornataCrudDao();
	
	public List<GiornataBean> findAllGiornate() {
		
		List<GiornataBean> result = giornataDao.findAll();
		
		return result;
	}
	
	public GiornataBean findById(Long id) {
		
		GiornataBean result = giornataDao.findById(id);
		
		return result;
	}
	
	public GiornataBean insertGiornata() {
		
		GiornataBean result = giornataDao.insert();
		
		return result;
	}
	
	public GiornataBean updateGiornata(Long id) {
		
		GiornataBean result = giornataDao.update(id);
		
		return result;
	}
	
	public void deleteGiornata(Long id) {
		
		giornataDao.delete(id);
		
		
	}

}
