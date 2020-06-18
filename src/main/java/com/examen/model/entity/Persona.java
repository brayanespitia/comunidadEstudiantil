package com.examen.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String nombre;

	private String telefono;

	private String esp;

	private String modalidad;

	private String genero;

	private String viveMas60;

	private String viveMenos15;

	private String viveSalud;

	private String diabetes;
	
	private String enfermedadCardioVascular;
	
	private String accidenteCardioVascular;
	
	private String vih;
	
	private String cancer;
	
	private String usoInmuno;
	
	private String enfermedadObstructivaCronica;
	
	private String malNutricion;
	
	private String fuma;

	@ManyToOne(fetch = FetchType.LAZY)
	private TipoPersona tipo;

	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy = "id",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ingreso> ingreso;
	
	
	public Ingreso addPersona(Ingreso ingreso) {
		getIngreso().add(ingreso);
		ingreso.setPersona(this);

		return ingreso;
	}

	public Ingreso removePersona(Ingreso ingreso) {
		getIngreso().remove(ingreso);
		ingreso.setPersona(null);

		return ingreso;
	}
	
	
	public List<Ingreso> getIngreso() {
		return ingreso;
	}

	public void setIngreso(List<Ingreso> ingreso) {
		this.ingreso = ingreso;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoPersona getTipo() {
		return tipo;
	}

	public void setTipo(TipoPersona tipo) {
		this.tipo = tipo;
	}

	public String getEsp() {
		return esp;
	}

	public void setEsp(String esp) {
		this.esp = esp;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getViveMas60() {
		return viveMas60;
	}

	public void setViveMas60(String viveMas60) {
		this.viveMas60 = viveMas60;
	}

	public String getViveMenos15() {
		return viveMenos15;
	}

	public void setViveMenos15(String viveMenos15) {
		this.viveMenos15 = viveMenos15;
	}

	public String getViveSalud() {
		return viveSalud;
	}

	public void setViveSalud(String viveSalud) {
		this.viveSalud = viveSalud;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getEnfermedadCardioVascular() {
		return enfermedadCardioVascular;
	}

	public void setEnfermedadCardioVascular(String enfermedadCardioVascular) {
		this.enfermedadCardioVascular = enfermedadCardioVascular;
	}

	public String getAccidenteCardioVascular() {
		return accidenteCardioVascular;
	}

	public void setAccidenteCardioVascular(String accidenteCardioVascular) {
		this.accidenteCardioVascular = accidenteCardioVascular;
	}

	public String getVih() {
		return vih;
	}

	public void setVih(String vih) {
		this.vih = vih;
	}

	public String getCancer() {
		return cancer;
	}

	public void setCancer(String cancer) {
		this.cancer = cancer;
	}

	public String getUsoInmuno() {
		return usoInmuno;
	}

	public void setUsoInmuno(String usoInmuno) {
		this.usoInmuno = usoInmuno;
	}

	public String getEnfermedadObstructivaCronica() {
		return enfermedadObstructivaCronica;
	}

	public void setEnfermedadObstructivaCronica(String enfermedadObstructivaCronica) {
		this.enfermedadObstructivaCronica = enfermedadObstructivaCronica;
	}

	public String getMalNutricion() {
		return malNutricion;
	}

	public void setMalNutricion(String malNutricion) {
		this.malNutricion = malNutricion;
	}

	public String getFuma() {
		return fuma;
	}

	public void setFuma(String fuma) {
		this.fuma = fuma;
	}

}