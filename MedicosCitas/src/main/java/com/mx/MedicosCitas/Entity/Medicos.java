package com.mx.MedicosCitas.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICOS")

public class Medicos {

	/*
	 * ID_MEDICO NUMBER, NOMBRE VARCHAR2(100), ESPECIALIDAD VARCHAR2(100), TELEFONO
	 * VARCHAR2(15),
	 */

	@Id
	private Long idMedico;
	@Column
	private String nombre;
	@Column
	private String especialidad;
	@Column
	private String telefono;
	
	// reference a la otra tabla:
	
		@OneToMany (mappedBy = "medicoId", cascade = CascadeType.ALL)
		List<Citas> lista = new ArrayList<>();
		

	public Medicos() {
	}

	public Medicos(Long idMedico, String nombre, String especialidad, String telefono) {
		this.idMedico = idMedico;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.telefono = telefono;
	}

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
