package com.examen.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.model.dao.IPersonaDao;
import com.examen.model.dao.IRolDao;
import com.examen.model.dao.IUsuarioDao;
import com.examen.model.entity.Persona;
import com.examen.model.entity.Rol;
import com.examen.model.entity.Usuario;

@Service
public class PersonaServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private IPersonaDao personaDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(long id) {		
		// TODO Auto-generated method stub
		return (T) personaDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) personaDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		personaDao.save((Persona)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		personaDao.delete((Persona) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(long entityId) {
		// TODO Auto-generated method stub
		personaDao.deleteById(entityId);
	}

	

}
