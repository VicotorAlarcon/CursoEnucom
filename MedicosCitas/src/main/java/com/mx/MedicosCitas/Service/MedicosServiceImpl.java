package com.mx.MedicosCitas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.MedicosCitas.Dao.IMedicosDao;
import com.mx.MedicosCitas.Entity.Medicos;



@Service
@Transactional

public class MedicosServiceImpl implements IMedicosService {
	
	@Autowired
	private IMedicosDao dao;

	@Override
	public Medicos guardar(Medicos medico) {
		
		return dao.save(medico);
	}

	@Override
	public Medicos editar(Medicos medico) {
		Medicos aux = this.buscar(medico); 
		if(aux != null) {
			dao.save(medico);
		}
		return null;
	}

	@Override
	public Medicos eliminar(Medicos medico) {
		Medicos aux = this.buscar(medico); 
		if(aux != null) {
			dao.delete(medico);
			return aux;
		}
		return null;
	}

	@Override
	public Medicos buscar(Medicos medico) {
		
		return dao.findById(medico.getIdMedico()).orElse(null);
	}

	@Override
	public List<Medicos> listar() {
		
		return dao.findAll(Sort.by(Direction.ASC, "idMedico"));
	}
	
	public List<Medicos> buscarPorEspecialidad (String especialidad){
		return dao.findByEspecialidad(especialidad);
	}

}
