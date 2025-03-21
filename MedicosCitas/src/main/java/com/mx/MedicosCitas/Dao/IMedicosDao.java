package com.mx.MedicosCitas.Dao;

import org.springframework.data.jpa.repository.Query;

import com.mx.MedicosCitas.Entity.Medicos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IMedicosDao extends JpaRepository <Medicos, Long> {
	
	@Query(nativeQuery = true,
			value = "SELECT ID_MEDICO, NOMBRE, ESPECIALIDAD, TELEFONO "
					+ "FROM MEDICOS "
					+ "WHERE UPPER (ESPECIALIDAD) = UPPER (:especialidad) "
					+ "ORDER BY ID_MEDICO ASC ")
	public List<Medicos> findByEspecialidad(String especialidad);
	
	
	public List<Medicos> findByEspecialidadIgnoringCaseOrderByIdMedico(String especialidad);
	
	
	
	
	

}
