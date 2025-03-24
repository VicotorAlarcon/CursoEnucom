package com.mx.ATM.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cajero")
public class Cajero {

	@Id
	private Long idCajero;
	@Column
	private String tipo;
	@Column
	private int cantidad;
	@Column
	private int denominaion;

	public Cajero() {
	}

	public Cajero(Long idCajero, String tipo, int cantidad, int denominaion) {
		this.idCajero = idCajero;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.denominaion = denominaion;
	}

	@Override
	public String toString() {
		return "Cajero [idCajero=" + idCajero + ", tipo=" + tipo + ", cantidad=" + cantidad + ", denominaion="
				+ denominaion + "]";
	}

	public Long getIdCajero() {
		return idCajero;
	}

	public void setIdCajero(Long idCajero) {
		this.idCajero = idCajero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getDenominaion() {
		return denominaion;
	}

	public void setDenominaion(int denominaion) {
		this.denominaion = denominaion;
	}

	
}
