package com.mx.SalaCine.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.SalaCine.Entity.Sala;
import java.util.List;


public interface ISalaDao extends JpaRepository<Sala, Long>{
	
	// Crear metodos personalizados co palabras clave o con la anotacion @Query
	
	// metodo que buscara una sala por categoria
	
	@Query(nativeQuery = true,
			value = "SELECT ID_SALA, NO_ASIENTOS, TIPO_PANTALLA, CATEGORIA "
					+ "FROM SALA_CINE "
					+ "WHERE UPPER (CATEGORIA) = UPPER (:categoria) "
					+ "ORDER BY ID_SALA ASC ")
	public List<Sala> findByCategoria(String categoria);
	
	//Metodo personalizado con palabra clave
	
	public List<Sala> findByCategoriaIgnoringCaseOrderByIdSala(String cactegoria);
	
	
	
	
	

}
