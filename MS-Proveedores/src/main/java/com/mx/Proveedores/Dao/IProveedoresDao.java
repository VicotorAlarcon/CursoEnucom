package com.mx.Proveedores.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.Proveedores.Entity.Proveedores;

@Repository
public interface IProveedoresDao extends JpaRepository<Proveedores, Long> {
	
	@Query(nativeQuery = true,
			value = "SELECT * FROM PROVEEDORES "
					+ "WHERE TIENDA_ID = :tiendaId ")

	public List<Proveedores> findByTiendaId(int tiendaId);
	

}
