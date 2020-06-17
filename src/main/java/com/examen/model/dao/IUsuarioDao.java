package com.examen.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.examen.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository <Usuario, Long>{
	
	public Usuario findByUsername(String username);
}
