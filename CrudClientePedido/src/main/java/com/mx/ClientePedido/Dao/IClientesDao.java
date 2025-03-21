package com.mx.ClientePedido.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.ClientePedido.Entity.Clientes;

public interface IClientesDao extends JpaRepository<Clientes, Long> {

	@Query(nativeQuery = true, 
			value = "SELECT ID_CLIENTE, NOMBRE, APELLIDOS, DIRECCION, TELEFONO "
			+ "FROM CLIENTES "
			+ "WHERE UPPER (NOMBRE) = UPPER (:nombre) " 
			+ "ORDER BY ID_CLIENTE ASC ")

	public List<Clientes> findByNombre(String nombre);

	// Metodo personalizado con palabra clave

	public List<Clientes> findByNombreIgnoringCaseOrderByIdCliente(String nombre);

}
