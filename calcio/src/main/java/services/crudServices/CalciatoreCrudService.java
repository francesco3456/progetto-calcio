package services.crudServices;

import java.util.List;

import model.dto.CalciatoreDto;
import model.dao.crudDao.CalciatoreCrudDao;

public class CalciatoreCrudService {
	
	CalciatoreCrudDao calciatoreDao = new CalciatoreCrudDao();
	
	public List<CalciatoreDto> findAllCalciatori() {
		
		List<CalciatoreDto> result = calciatoreDao.findAll();
		
		return result;
	}
	
	public CalciatoreDto findById(Long id) {
		
		CalciatoreDto result = calciatoreDao.findById(id);
		
		return result;
	}
	
	public CalciatoreDto insertCalciatore() {
		
		CalciatoreDto result = calciatoreDao.insert();
		
		return result;
	}
	
	public CalciatoreDto updateCalciatore(Long id) {
		
		CalciatoreDto result = calciatoreDao.update(id);
		
		return result;
	}
	
	public void deleteCalciatore(Long id) {
		
		calciatoreDao.delete(id);
	}

}
