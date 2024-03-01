package services.crudServices;

import java.util.List;

import model.bean.ClassificaBean;
import model.dao.crudDao.ClassificaCrudDao;

public class ClassificaCrudService {
	
	ClassificaCrudDao classificaDao = new ClassificaCrudDao();
	
	public List<ClassificaBean> findAllPunteggi() {
		
		List<ClassificaBean> result = classificaDao.findAll();
		
		return result;
	}
	
	public ClassificaBean findById(Long id) {
		
		ClassificaBean result = classificaDao.findById(id);
		
		return result;
	}
	
	public ClassificaBean insertPunteggio() {
		
		ClassificaBean result = classificaDao.insert();
		
		return result;
	}
	
	public ClassificaBean updatePunteggio(Long id) {
		
		ClassificaBean result = classificaDao.update(id);
		
		return result;
	}
	
	public void deletePunteggio(Long id) {
		
		classificaDao.delete(id);
	}

}
