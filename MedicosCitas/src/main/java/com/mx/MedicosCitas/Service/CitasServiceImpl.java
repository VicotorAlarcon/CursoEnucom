package com.mx.MedicosCitas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.MedicosCitas.Dao.ICitasDao;
import com.mx.MedicosCitas.Entity.Citas;


@Service
@Transactional

public class CitasServiceImpl implements ICitasService {
	
	@Autowired
	private ICitasDao dao;

	@Override
	public Citas guardar(Citas cita) {
		
		return dao.save(cita);
	}

	@Override
	public Citas editar(Citas cita) {
		Citas aux = this.buscar(cita);
		 if(aux != null) {
			 return dao.save(cita);
		 }
		return null;
	}

	@Override
	public Citas eliminar(Citas cita) {
		Citas aux = this.buscar(cita);
		 if(aux != null) {
			 dao.delete(cita);
			 return aux;
		 }
		return null;
	}

	@Override
	public Citas buscar(Citas cita) {
		
		return dao.findById(cita.getIdCita()).orElse(null);
	}

	@Override
	public List<Citas> listar() {
		
		return dao.findAll(Sort.by(Direction.ASC, "idCita"));
	}
	
	public List<Citas> buscarPorMotivo (String motivo){
		return dao.FindByMotivo(motivo);
	}
	
	public List<Citas> buscarPorPacienteNombre (String pacienteNombre){
	return dao.findByPacienteNombre(pacienteNombre);
	}
	
	
	public List<Citas> buscarPorPacienteNombre2 (String pacienteNombre){
		return dao.findByPacienteNombreContainingIgnoringCaseOrderByIdCita(pacienteNombre);
	}

}
