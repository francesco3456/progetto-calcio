package model.daoInterface;

import java.util.List;

public interface CrudDao<T> {
	
	public List<T> findAll();
	
	public T update(Long id);
	
	public void delete(Long id);
	
	public T insert();
	
	public T findById(Long id);

}
