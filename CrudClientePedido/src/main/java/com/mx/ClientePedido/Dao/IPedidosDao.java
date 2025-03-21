package com.mx.ClientePedido.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.ClientePedido.Entity.Pedidos;


@Repository

public interface IPedidosDao extends JpaRepository<Pedidos, Long> {
	
	@Query (nativeQuery = true, 
			value = "SELECT ID_PEDIDO, FECHA_PEDIDO, TOTAL, ESTADO, ESTATUS, ID_CLIENTES "
					+ "FROM PEDIDOS "
					+ "WHERE UPPER (ESTADO) LIKE '%' || UPPER (:estado) || '%'")
	public List<Pedidos> FindByEstado(@Param ("estado") String estado);
	
	@Query(nativeQuery = true,
			value = "SELECT ID_PEDIDO, FECHA_PEDIDO, TOTAL, ESTADO, ESTATUS, ID_CLIENTES "
					+ "FROM PEDIDOS "
					+ "WHERE UPPER (ESTATUS) = UPPER (:estatus)")
	public List<Pedidos> findByEstatus(@Param ("estatus") String estatus);

}





