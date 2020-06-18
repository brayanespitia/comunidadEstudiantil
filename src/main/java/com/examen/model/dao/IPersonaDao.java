package com.examen.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.model.entity.Persona;

public interface IPersonaDao extends CrudRepository <Persona, Long>{
	
}
