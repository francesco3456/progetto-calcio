package services.crudServices;

import java.util.List;

import model.bean.CalciatoreBean;
import model.dao.crudDao.CalciatoreCrudDao;

public class CalciatoreCrudService {
	
	CalciatoreCrudDao calciatoreDao = new CalciatoreCrudDao();
	
	public List<CalciatoreBean> findAllCalciatori() {
		
		List<CalciatoreBean> result = calciatoreDao.findAll();
		
		return result;
	}
	
	public CalciatoreBean findById(Long id) {
		
		CalciatoreBean result = calciatoreDao.findById(id);
		
		return result;
	}
	
	public CalciatoreBean insertCalciatore() {
		
		CalciatoreBean result = calciatoreDao.insert();
		
		return result;
	}
	
	public CalciatoreBean updateCalciatore(Long id) {
		
		CalciatoreBean result = calciatoreDao.update(id);
		
		return result;
	}
	
	public void deleteCalciatore(Long id) {
		
		calciatoreDao.delete(id);
	}

}
