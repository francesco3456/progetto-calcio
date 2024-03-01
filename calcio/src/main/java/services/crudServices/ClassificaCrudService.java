package services.crudServices;

import java.util.List;

import model.dao.crudDao.ClassificaCrudDao;
import model.dto.ClassificaDto;

public class ClassificaCrudService {
	
	ClassificaCrudDao classificaDao = new ClassificaCrudDao();
	
	public List<ClassificaDto> findAllPunteggi() {
		
		List<ClassificaDto> result = classificaDao.findAll();
		
		return result;
	}
	
	public ClassificaDto findById(Long id) {
		
		ClassificaDto result = classificaDao.findById(id);
		
		return result;
	}
	
	public ClassificaDto insertPunteggio() {
		
		ClassificaDto result = classificaDao.insert();
		
		return result;
	}
	
	public ClassificaDto updatePunteggio(Long id) {
		
		ClassificaDto result = classificaDao.update(id);
		
		return result;
	}
	
	public void deletePunteggio(Long id) {
		
		classificaDao.delete(id);
	}

}
