package services.crudServices;

import java.util.List;

import model.bean.PartitaBean;
import model.dao.crudDao.PartitaCrudDao;

public class PartitaCrudService {
	
	PartitaCrudDao partitaDao = new PartitaCrudDao();
	
	public List<PartitaBean> findAllPartite() {
		
		List<PartitaBean> result = partitaDao.findAll();
		
		return result;
	}
	
	public PartitaBean findById(Long id) {
		
		PartitaBean result = partitaDao.findById(id);
		
		return result;
	}
	
	public PartitaBean insertPartita() {
		
		PartitaBean result = partitaDao.insert();
		
		return result;
	}
	
	public PartitaBean updatePartita(Long id) {
		
		PartitaBean result = partitaDao.update(id);
		
		return result;
	}
	
	public void deletePartita(Long id) {
		
		partitaDao.delete(id);
	}

}
