package com.examen.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name = "rol")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Long idrol;

	private String descripcion;
	
	@OneToMany(mappedBy = "idrol",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Usuario> usuarios;

	public Rol() {
	}

	public Long getIdrol() {
		return this.idrol;
	}

	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getPersonas() {
		return this.usuarios;
	}

	public void setPersonas(List<Usuario> personas) {
		this.usuarios = personas;
	}

	public Usuario addPersona(Usuario persona) {
		getPersonas().add(persona);
		persona.setRol(this);

		return persona;
	}

	public Usuario removePersona(Usuario persona) {
		getPersonas().remove(persona);
		persona.setRol(null);

		return persona;
	}

}