package com.mx.MedicosCitas.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.MedicosCitas.Entity.Citas;


@Repository

public interface ICitasDao extends JpaRepository<Citas, Long> {
	
	@Query (nativeQuery = true, 
			value = "SELECT ID_CITA, PACIENTE_NOMBRE, FECHA_CITA, MOTIVO, MEDICO_ID "
					+ "FROM CITAS "
					+ "WHERE UPPER (MOTIVO) LIKE '%' || UPPER (?) || '%' ")
	public List<Citas> FindByMotivo(@Param ("motivo") String motivo);
	
	@Query(nativeQuery = true,
			value = "SELECT ID_CITA, PACIENTE_NOMBRE, FECHA_CITA, MOTIVO, MEDICO_ID "
					+ "FROM CITAS "
					+ "WHERE UPPER (PACIENTE_NOMBRE) LIKE  '%' || UPPER (:pacienteNombre) || '%' ")
	public List<Citas> findByPacienteNombre(@Param ("pacienteNombre") String pacienteNombre);
	
	
	public List<Citas> findByPacienteNombreContainingIgnoringCaseOrderByIdCita(String pacienteNombre);

}




