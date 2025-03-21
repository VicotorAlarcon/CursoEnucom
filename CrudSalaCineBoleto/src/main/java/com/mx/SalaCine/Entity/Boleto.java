package com.mx.SalaCine.Entity;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;

@Entity
// @Table (name = "BOLETO")
public class Boleto {

	/*
	 * ID_BOLETO NUMBER, NOM_PELICULA NVARCHAR2 (100), CLASIFICACION NVARCHAR2 (50),
	 * NOM_ASIENTO NVARCHAR2 (5), FECHA DATE, SALA_ID NUMBER,
	 */

	@Id
	private Long idBoleto;
	@Column(name = "NOM_PELICULA")
	private String nombrePelicula;
	@Column
	private String clasificacion;
	@Column (name = "NOM_ASIENTO")
	private String noAsiento;
	@Column	
	private LocalDate fecha;

	@ManyToOne(fetch = FetchType.EAGER) // EAGER = carga inmediata
	@JoinColumn(name = "SALA_ID")
	private Sala salaId;

	public Boleto() {
	}

	public Boleto(Long idBoleto, String nombrePelicula, String clasificacion, String noAsiento, LocalDate fecha,
			Sala salaId) {
		this.idBoleto = idBoleto;
		this.nombrePelicula = nombrePelicula;
		this.clasificacion = clasificacion;
		this.noAsiento = noAsiento;
		this.fecha = fecha;
		this.salaId = salaId;
	}

	@Override
	public String toString() {
		return "Boleto [idBoleto=" + idBoleto + ", nombrePelicula=" + nombrePelicula + ", clasificacion="
				+ clasificacion + ", noAsiento=" + noAsiento + ", fecha=" + fecha + ", salaId=" + salaId + "]";
	}

	public Long getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(Long idBoleto) {
		this.idBoleto = idBoleto;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getNoAsiento() {
		return noAsiento;
	}

	public void setNoAsiento(String noAsiento) {
		this.noAsiento = noAsiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Sala getSalaId() {
		return salaId;
	}

	public void setSalaId(Sala salaId) {
		this.salaId = salaId;
	}

}
