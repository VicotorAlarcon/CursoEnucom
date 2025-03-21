package com.mx.ClientePedido.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Pedidos {
	/*
	 * ID_PEDIDO NUMBER, FECHA_PEDIDO DATE, TOTAL NUMBER(10,2), ESTADO NVARCHAR2
	 * (30), ESTATUS NVARCHAR2 (30), ID_CLIENTES NUMBER
	 */

	@Id
	private Long idPedido;
	@Column
	private Date fechaPedido;
	@Column
	private Long total;
	@Column
	private String estado;
	@Column
	private String estatus;
	
	@ManyToOne(fetch = FetchType.EAGER) // EAGER = carga inmediata
	@JoinColumn(name = "ID_CLIENTES")
	private Clientes idClientes;

	public Pedidos() {
	}

	

	public Pedidos(Long idPedido, Date fechaPedido, Long total, String estado, String estatus, Clientes idClientes) {
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.total = total;
		this.estado = estado;
		this.estatus = estatus;
		this.idClientes = idClientes;
	}



	

	@Override
	public String toString() {
		return "Pedidos [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", total=" + total + ", estado="
				+ estado + ", estatus=" + estatus + ", idClientes=" + idClientes + "]";
	}



	public Long getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}



	public Date getFechaPedido() {
		return fechaPedido;
	}



	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}



	public Long getTotal() {
		return total;
	}



	public void setTotal(Long total) {
		this.total = total;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getEstatus() {
		return estatus;
	}



	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}



	public Clientes getIdClientes() {
		return idClientes;
	}



	public void setIdClientes(Clientes idClientes) {
		this.idClientes = idClientes;
	}




}
