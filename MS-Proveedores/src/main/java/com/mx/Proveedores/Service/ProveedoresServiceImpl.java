package com.mx.Proveedores.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.mx.Proveedores.Dao.IProveedoresDao;
import com.mx.Proveedores.Entity.Proveedores;



@Service

public class ProveedoresServiceImpl implements IProveedoresService {
	
	//Inyeccion de dependencias
	@Autowired
	private IProveedoresDao dao;

	@Override
	public Proveedores guardar(Proveedores provedor) {
		
		return dao.save(provedor);
	}

	@Override
	public Proveedores editar(Proveedores provedor) {
		Proveedores aux = this.buscar(provedor.getId());
		if(aux != null) {
			return dao.save(provedor);
		}
		return null;
	}

	@Override
	public Proveedores eliminar(Long id) {
		Proveedores aux = this.buscar(id);
		if(aux != null) {
			dao.deleteById(id);
		}
		return aux;
	}

	@Override
	public Proveedores buscar(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Proveedores> listar() {
		
		return dao.findAll(Sort.by(Direction.DESC,"id"));
		
	}
	
	public List<Proveedores> buscarPorTiendaId (int tiendaId){
		return dao.findByTiendaId(tiendaId);
	}

	
	
}
