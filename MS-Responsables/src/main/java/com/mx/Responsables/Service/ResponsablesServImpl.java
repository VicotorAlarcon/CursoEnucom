package com.mx.Responsables.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Responsables.Dao.IResponsablesDao;
import com.mx.Responsables.Entity.Responsables;

@Service
public class ResponsablesServImpl implements ResponsablesService {

	@Autowired
	private IResponsablesDao dao;
	
	@Override
	public Responsables guardar(Responsables responsable) {
		
		return dao.save(responsable);
	}

	@Override
	public Responsables editar(Responsables responsable) {
		Responsables aux =this.buscar(responsable.getIdResponsable());
		if(aux != null) {
			return dao.save(responsable);
		}
		
		return null;
	}

	@Override
	public Responsables eliminar(Long idResponsable) {
		Responsables aux = this.buscar(idResponsable);
		if (aux != null) {
			dao.deleteById(idResponsable);
		}
		return null;
	}

	@Override
	public Responsables buscar(Long idResponsable) {
		
		return dao.findById(idResponsable).orElse(null);
	}

	@Override
	public List<Responsables> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC, "idResponsable"));
	}
	
	public List<Responsables> byVeterinariaId(int veterinariaId){
		return dao.findByVeterinariaId(veterinariaId);
	}
	

}
