package dao;

import java.util.List;

public interface GeneticDao<T> {

	public T create(T t);
	
	public T update(T t);
	
	public T get(Object id); 
	
	public void delete(Object id);
	
	public List<T> listAll();
	
	public long count();
}
