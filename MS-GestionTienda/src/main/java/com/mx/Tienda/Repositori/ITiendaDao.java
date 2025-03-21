package com.mx.Tienda.Repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Tienda.Entity.Tienda;

@Repository
public interface ITiendaDao extends JpaRepository<Tienda, Integer> {

}
