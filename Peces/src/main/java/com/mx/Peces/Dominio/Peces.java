package com.mx.Peces.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PECES")

public class Peces {

	@Id
	@Column(name = "ID_PEZ", columnDefinition = "NUMBER")
	private int idPez;
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2 (50)")
	private String nombre;
	@Column(name = "", columnDefinition = "NVARCHAR2 (50)")
	private String especie;
	@Column(name = "PESO", columnDefinition = "NUMBER (5, 2)")
	private double peso;
	@Column(name = "LONGITUD", columnDefinition = "NUMBER (5, 2")
	private double longitud;

	public Peces() {
		super();
	}

	public Peces(int idPez, String nombre, String especie, double peso, double longitud) {
		super();
		this.idPez = idPez;
		this.nombre = nombre;
		this.especie = especie;
		this.peso = peso;
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Peces [idPez=" + idPez + ", nombre=" + nombre + ", especie=" + especie + ", peso=" + peso
				+ ", longitud=" + longitud + "]";
	}

	public int getIdPez() {
		return idPez;
	}

	public void setIdPez(int idPez) {
		this.idPez = idPez;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

}
