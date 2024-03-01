package services.crudServices;

import java.util.List;

import model.dao.crudDao.AllenatoreCrudDao;
import model.dto.AllenatoreDto;

public class AllenatoreCrudService {
	
	AllenatoreCrudDao allenatoreDao = new AllenatoreCrudDao();
	
	
	
	public List<AllenatoreDto> findAllAllenatori() {
		
		List<AllenatoreDto> result = allenatoreDao.findAll();
		
		return result;
		
	}
	
	public AllenatoreDto findById(Long id) {
		
		AllenatoreDto result = allenatoreDao.findById(id);
		
		return result;
	}
	
	public AllenatoreDto updateAllenatore(Long id) {
		
		AllenatoreDto result = allenatoreDao.update(id);
		
		return result;
	}
	
	public AllenatoreDto insertAllenatore() {
		
		AllenatoreDto result = allenatoreDao.insert();
		
		return result;
	}
	
	public void deleteAllenatore(Long id) {
		
		allenatoreDao.delete(id);
	}

}
