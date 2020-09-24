package com.andre.apirest.genericdao.repository;

import java.util.List;

public interface GenericRepository<T> {

	public List<T> findAll();

	public T findById(Integer id);

	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	

	

}
