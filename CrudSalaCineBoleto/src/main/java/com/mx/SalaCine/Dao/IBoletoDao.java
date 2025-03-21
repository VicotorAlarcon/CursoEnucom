package com.mx.SalaCine.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.SalaCine.Entity.Boleto;

@Repository
public interface IBoletoDao extends JpaRepository<Boleto, Long> {
	
	//Metodos personalizados 
	
	// obtener los boletos por nombre de la pelicula
	
	@Query (nativeQuery = true, 
			value = "SELECT ID_BOLETO, NOM_PELICULA, CLASIFICACION, NOM_ASIENTO, FECHA, SALA_ID "
					+ "FROM BOLETO "
					+ "WHERE UPPER (NOM_PELICULA) LIKE '%' || UPPER (?) || '%'")
	public List<Boleto> FindByNomPelicula(@Param ("nomPelicula") String nomPelicula);
	
	@Query(nativeQuery = true,
			value = "SELECT ID_BOLETO, NOM_PELICULA, CLASIFICACION, NOM_ASIENTO, FECHA, SALA_ID "
					+ "FROM BOLETO "
					+ "WHERE UPPER (CLASIFICACION) = UPPER (:clasificacion)")
	public List<Boleto> findByClasificacion(@Param ("clasificacion") String clasificacion);
	
	
	public List<Boleto> findByNombrePeliculaContainingIgnoringCaseOrderByIdBoleto(String nomPelicula);
	
	
	
	

}
