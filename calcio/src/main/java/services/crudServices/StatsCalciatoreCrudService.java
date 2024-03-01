package services.crudServices;

import java.util.List;

import model.dao.crudDao.StatsCrudDao;
import model.dto.StatsCalciatoreDto;

public class StatsCalciatoreCrudService {
	
	StatsCrudDao statsDao = new StatsCrudDao();
	
	public List<StatsCalciatoreDto> findAllStats() {
		
		List<StatsCalciatoreDto> result = statsDao.findAll();
		
		return result;
	}
	
	public StatsCalciatoreDto findById(Long id) {
		
		StatsCalciatoreDto result = statsDao.findById(id);
		
		return result;
	}
	
	public StatsCalciatoreDto insertStats() {
		
		StatsCalciatoreDto result = statsDao.insert();
		
		return result;
	}
	
	public StatsCalciatoreDto updateStats(Long id) {
		
		StatsCalciatoreDto result = statsDao.update(id);
		
		return result;
	}
	
	public void deleteStats(Long id) {
		
		statsDao.delete(id);
	}

}
