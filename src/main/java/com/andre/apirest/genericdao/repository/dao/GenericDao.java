package com.andre.apirest.genericdao.repository.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.andre.apirest.genericdao.repository.GenericRepository;

public abstract class GenericDao<T> implements GenericRepository<T> {

	private final Class<T> persistentClass;

	@PersistenceContext
	private EntityManager entityManager;

	public GenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return this.entityManager
				.createQuery("select c from " + this.persistentClass.getSimpleName() + " c", persistentClass)
				.getResultList();
	}

	@Override
	@Transactional
	public T findById(Integer id) {
		return this.entityManager.find(persistentClass, id);
	}

	@Override
	@Transactional
	public void save(T entity) {
		this.entityManager.persist(entity);
	}

	@Override
	@Transactional
	public void update(T entity) {
		this.entityManager.merge(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		this.entityManager.remove(entity);
	}

}
