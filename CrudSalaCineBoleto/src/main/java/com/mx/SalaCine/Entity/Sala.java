package com.mx.SalaCine.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "SALA_CINE")
public class Sala {

	/*
	 * ID_SALA NUMBER, NO_ASIENTOS NUMBER, TIPO_PANTALLA NVARCHAR2 (50), CATEGORIA
	 * NVARCHAR2 (50)
	 * 
	 */

	@Id
	@Column
	private Long idSala;
	@Column
	private int noAsientos;
	@Column 
	private String tipoPantalla;
	@Column
	private String categoria;
	
	
	// reference a la otra tabla:
	
	@OneToMany (mappedBy = "salaId", cascade = CascadeType.ALL)
	List<Boleto> lista = new ArrayList<>();
	
	
	
	public Sala() {
		
	}

	public Sala(Long idSala, int noAsientos, String tipoPantalla, String categoria) {
		super();
		this.idSala = idSala;
		this.noAsientos = noAsientos;
		this.tipoPantalla = tipoPantalla;
		this.categoria = categoria;
	}	


	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", noAsientos=" + noAsientos + ", tipoPantalla=" + tipoPantalla
				+ ", categoria=" + categoria + "]";
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public int getNoAsientos() {
		return noAsientos;
	}

	public void setNoAsientos(int noAsientos) {
		this.noAsientos = noAsientos;
	}

	public String getTipoPantalla() {
		return tipoPantalla;
	}

	public void setTipoPantalla(String tipoPantalla) {
		this.tipoPantalla = tipoPantalla;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
