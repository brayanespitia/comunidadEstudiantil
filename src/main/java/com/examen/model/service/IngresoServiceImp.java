package com.examen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.model.dao.IIngresoDao;
import com.examen.model.entity.Ingreso;


@Service
public class IngresoServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private IIngresoDao ingresoDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(long id) {		
		// TODO Auto-generated method stub
		return (T) ingresoDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) ingresoDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		ingresoDao.save((Ingreso)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		ingresoDao.delete((Ingreso) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(long entityId) {
		// TODO Auto-generated method stub
		ingresoDao.deleteById(entityId);
	}

	

}
