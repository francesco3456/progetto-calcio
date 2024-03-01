package services.crudServices;

import java.util.List;

import model.dao.crudDao.GiornataCrudDao;
import model.dto.GiornataDto;

public class GiornataCrudService {
	
	GiornataCrudDao giornataDao = new GiornataCrudDao();
	
	public List<GiornataDto> findAllGiornate() {
		
		List<GiornataDto> result = giornataDao.findAll();
		
		return result;
	}
	
	public GiornataDto findById(Long id) {
		
		GiornataDto result = giornataDao.findById(id);
		
		return result;
	}
	
	public GiornataDto insertGiornata() {
		
		GiornataDto result = giornataDao.insert();
		
		return result;
	}
	
	public GiornataDto updateGiornata(Long id) {
		
		GiornataDto result = giornataDao.update(id);
		
		return result;
	}
	
	public void deleteGiornata(Long id) {
		
		giornataDao.delete(id);
		
		
	}

}
