package model.repositoryInterface;

import java.util.List;

public interface CrudRepository<T> {
	
	public List<T> findAll();
	
	public T update(Long id);
	
	public void delete(Long id);
	
	public T insert();
	
	public T findById(Long id);

}
