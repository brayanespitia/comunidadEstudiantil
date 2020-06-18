package com.examen.model.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericService2<T> extends Serializable{
	
	T findOne(long id);

	List<T> findAll();

	void save(T entity);

	void delete(T entity);

	void deleteById(long entityId);
}
