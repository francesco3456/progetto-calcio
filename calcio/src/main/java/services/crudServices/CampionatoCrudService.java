package services.crudServices;

import java.util.List;

import model.bean.CampionatoBean;
import model.dao.crudDao.CampionatoCrudDao;

public class CampionatoCrudService {
	
	CampionatoCrudDao campionatoDao = new CampionatoCrudDao();
	
	public List<CampionatoBean> findAllCampionati() {
		
		List<CampionatoBean> result = campionatoDao.findAll();
		
		return result;
	}
	
	public CampionatoBean findById(Long id) {
		
		CampionatoBean result = campionatoDao.findById(id);
		
		return result;
	}
	
	public CampionatoBean insertCampionato() {
		
		CampionatoBean result = campionatoDao.insert();
		
		return result;
	}
	
	public CampionatoBean updateCampionato(Long id) {
		
		CampionatoBean result = campionatoDao.update(id);
		
		return result;
	}
	
	public void deleteCampionato(Long id) {
		
		campionatoDao.delete(id);
	}

}
