package com.mx.Clientes.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Clientes.Entity.Clientes;


@Repository
public interface IClientesDao extends JpaRepository<Clientes, Long> {
	
	public List<Clientes> findByTiendaId(int tiendaId);

}
