package com.mx.ClientePedido.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ClientePedido.Dao.IClientesDao;
import com.mx.ClientePedido.Entity.Clientes;


@Service
@Transactional

public class ClientesServiceImpl implements IClientesService {
	
	//Inyeccion de dependencias
		@Autowired
		private IClientesDao dao;

	@Override
	public Clientes guardar(Clientes clientes) {
		return dao.save(clientes);
	}

	@Override
	public Clientes editar(Clientes clientes) {
		Clientes aux = this.buscar(clientes); 
		if(aux != null) {
			dao.save(clientes);
		}
		return null;
	}

	@Override
	public Clientes eliminar(Clientes clientes) {
		Clientes aux = this.buscar(clientes); 
		if(aux != null) {
			dao.delete(clientes);
			return aux;
		}
		return null;
	}

	@Override
	public Clientes buscar(Clientes clientes) {
		
		return dao.findById(clientes.getIdCliente()).orElse(null);
	}

	@Override
	public List<Clientes> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "idCliente"));
	}
	
	
	//Metodos personalizados 
	
	
		public List<Clientes> buscarPorNombre (String nombre){
			return dao.findByNombre(nombre);
		}
		
		public List<Clientes> buscarPorNombre2 (String nombre){
			return dao.findByNombreIgnoringCaseOrderByIdCliente(nombre);
		}
	

}
