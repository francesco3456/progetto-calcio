package services.crudServices;

import java.util.List;

import model.bean.StatsCalciatoreBean;
import model.dao.crudDao.StatsCrudDao;

public class StatsCalciatoreCrudService {
	
	StatsCrudDao statsDao = new StatsCrudDao();
	
	public List<StatsCalciatoreBean> findAllStats() {
		
		List<StatsCalciatoreBean> result = statsDao.findAll();
		
		return result;
	}
	
	public StatsCalciatoreBean findById(Long id) {
		
		StatsCalciatoreBean result = statsDao.findById(id);
		
		return result;
	}
	
	public StatsCalciatoreBean insertStats() {
		
		StatsCalciatoreBean result = statsDao.insert();
		
		return result;
	}
	
	public StatsCalciatoreBean updateStats(Long id) {
		
		StatsCalciatoreBean result = statsDao.update(id);
		
		return result;
	}
	
	public void deleteStats(Long id) {
		
		statsDao.delete(id);
	}

}
