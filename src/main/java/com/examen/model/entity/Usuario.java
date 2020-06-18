package com.examen.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long idUsuario;

	private String password;	
	
	private String username;
	
	private String empresa;
	
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Rol idrol;

	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.idUsuario = id;
	}

	public Rol getRol() {
		return idrol;
	}

	public void setRol(Rol idrol) {
		this.idrol = idrol;
	}

		
}