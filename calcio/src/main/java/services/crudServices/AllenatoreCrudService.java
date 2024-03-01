package services.crudServices;

import java.util.List;

import model.bean.AllenatoreBean;
import model.dao.crudDao.AllenatoreCrudDao;

public class AllenatoreCrudService {
	
	AllenatoreCrudDao allenatoreDao = new AllenatoreCrudDao();
	
	
	
	public List<AllenatoreBean> findAllAllenatori() {
		
		List<AllenatoreBean> result = allenatoreDao.findAll();
		
		return result;
		
	}
	
	public AllenatoreBean findById(Long id) {
		
		AllenatoreBean result = allenatoreDao.findById(id);
		
		return result;
	}
	
	public AllenatoreBean updateAllenatore(Long id) {
		
		AllenatoreBean result = allenatoreDao.update(id);
		
		return result;
	}
	
	public AllenatoreBean insertAllenatore() {
		
		AllenatoreBean result = allenatoreDao.insert();
		
		return result;
	}
	
	public void deleteAllenatore(Long id) {
		
		allenatoreDao.delete(id);
	}

}
