package com.mx.MedicosCitas.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Citas {

	/*
	 * ID_CITA NUMBER, PACIENTE_NOMBRE VARCHAR2(100), FECHA_CITA DATE, MOTIVO
	 * VARCHAR2(255), MEDICO_ID NUMBER,
	 */
	
	@Id
	private Long idCita;
	@Column
	private String pacienteNombre;
	@Column
	private Date fechaCita;
	@Column
	private String motivo;
	
	@ManyToOne(fetch = FetchType.EAGER) // EAGER = carga inmediata
	@JoinColumn(name = "MEDICO_ID")
	private Medicos medicoId;

	public Citas() {
	}

	public Citas(Long idCita, String pacienteNombre, Date fechaCita, String motivo, Medicos medicoId) {
		this.idCita = idCita;
		this.pacienteNombre = pacienteNombre;
		this.fechaCita = fechaCita;
		this.motivo = motivo;
		this.medicoId = medicoId;
	}

	@Override
	public String toString() {
		return "Citas [idCita=" + idCita + ", pacienteNombre=" + pacienteNombre + ", fechaCita=" + fechaCita
				+ ", motivo=" + motivo + ", medicoId=" + medicoId + "]";
	}

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public String getPacienteNombre() {
		return pacienteNombre;
	}

	public void setPacienteNombre(String pacienteNombre) {
		this.pacienteNombre = pacienteNombre;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Medicos getMedicoId() {
		return medicoId;
	}

	public void setMedicoId(Medicos medicoId) {
		this.medicoId = medicoId;
	}

}
