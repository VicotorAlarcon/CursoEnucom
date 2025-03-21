package com.mx.ClientePedido.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "CLIENTES")

public class Clientes {
	
	/*
	 * ID_CLIENTE NUMBER,
    NOMBRE NVARCHAR2(100),
    APELLIDOS NVARCHAR2 (100),
    DIRECCION NVARCHAR2(100),
    TELEFONO NVARCHAR2(20),
	 */
	
	
	@Id
	@Column
	private Long idCliente;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String direccion;
	@Column
	private String telefono;
	
	// referencia con la tabla hija
	
	@OneToMany (mappedBy = "idClientes", cascade = CascadeType.ALL)
	List<Pedidos> lista = new ArrayList<>();
	

	public Clientes() {
	}

	public Clientes(Long idCliente, String nombre, String apellidos, String direccion, String telefono) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	
	
	
	
	

}
