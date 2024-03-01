package services.crudServices;

import java.util.List;

import model.bean.SquadraBean;
import model.dao.crudDao.SquadraCrudDao;

public class SquadraCrudService {
	
	SquadraCrudDao squadraDao = new SquadraCrudDao();
	
	public List<SquadraBean> findAllSquadre() {
		
		List<SquadraBean> result = squadraDao.findAll();
		
		return result;
	}
	
	public SquadraBean findById(Long id) {
		
		SquadraBean result = squadraDao.findById(id);
		
		return result;
	}
	
	public SquadraBean insertSquadra() {
		
		SquadraBean result = squadraDao.insert();
		
		return result;
	}
	
	public SquadraBean updateSquadra(Long id) {
		
		SquadraBean result = squadraDao.update(id);
		
		return result;
	}
	
	public void deleteSquadra(Long id) {
		
		squadraDao.delete(id);
	}

}
