package model.daoInterface;

import java.util.List;


public interface CrudDao<T> {
	
	public List<T> findAll();
	
	public T update(T entity);
	
	public void delete(Long id);
	
	public T insert(T entity);
	
	public T findById(Long id);


}
