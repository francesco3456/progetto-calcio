package services.crudServices;

import java.util.List;

import model.dao.crudDao.SquadraCrudDao;
import model.dto.SquadraDto;

public class SquadraCrudService {
	
	SquadraCrudDao squadraDao = new SquadraCrudDao();
	
	public List<SquadraDto> findAllSquadre() {
		
		List<SquadraDto> result = squadraDao.findAll();
		
		return result;
	}
	
	public SquadraDto findById(Long id) {
		
		SquadraDto result = squadraDao.findById(id);
		
		return result;
	}
	
	public SquadraDto insertSquadra() {
		
		SquadraDto result = squadraDao.insert();
		
		return result;
	}
	
	public SquadraDto updateSquadra(Long id) {
		
		SquadraDto result = squadraDao.update(id);
		
		return result;
	}
	
	public void deleteSquadra(Long id) {
		
		squadraDao.delete(id);
	}

}
