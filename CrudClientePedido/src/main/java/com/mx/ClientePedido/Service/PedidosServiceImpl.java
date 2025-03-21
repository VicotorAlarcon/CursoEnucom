package com.mx.ClientePedido.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ClientePedido.Dao.IPedidosDao;
import com.mx.ClientePedido.Entity.Pedidos;

@Service
@Transactional

public class PedidosServiceImpl implements IPedidosService {
	
	// Inyeccion de dependencias
		@Autowired
		private IPedidosDao dao;

	@Override
	public Pedidos guardar(Pedidos pedidos) {
		return dao.save(pedidos);
	}

	@Override
	public Pedidos editar(Pedidos pedidos) {
		Pedidos aux = this.buscar(pedidos);
		 if(aux != null) {
			 return dao.save(pedidos);
		 }
		return null;
	}

	@Override
	public Pedidos eliminar(Pedidos pedidos) {
		Pedidos aux = this.buscar(pedidos);
		 if(aux != null) {
			 dao.delete(pedidos);
			 return aux;
		 }
		return null;
	}

	@Override
	public Pedidos buscar(Pedidos pedidos) {
		return dao.findById(pedidos.getIdPedido()).orElse(null);
	}

	@Override
	public List<Pedidos> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "idPedido"));
	}
	
	// metodo personalizado
	
		public List<Pedidos> buscarPorEstado (String estado){
			return dao.FindByEstado(estado);
		}
		
		public List<Pedidos> buscarPorClasificacion (String estatus){
		return dao.findByEstatus(estatus);
		}
	
	

}
