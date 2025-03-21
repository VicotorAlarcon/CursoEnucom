package com.mx.ClientePedido.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ClientePedido.Entity.Pedidos;
import com.mx.ClientePedido.Service.PedidosServiceImpl;




@RestController
@RequestMapping ("/pedido")
@CrossOrigin

public class PedidosWS {
	
	@Autowired
	private PedidosServiceImpl service;
	
	//listado http://localhost:8002/pedido/listar
	
		@GetMapping("listar")
				public List<Pedidos> listar(){
			return service.listar();
		}
		
		//buscar http://localhost:8002/pedido/buscar
		
		@PostMapping("buscar")
		public Pedidos buscar(@RequestBody Pedidos pedidos) {
			return service.buscar(pedidos);
		}
		
		
		//guardar http://localhost:8002/pedido/guardar
		@PostMapping("guardar")
		public Pedidos guardar (@RequestBody Pedidos pedidos) {
			return service.guardar(pedidos);
		}
		
		//Editar http://localhost:8002/pedido/editar
		
		@PutMapping("editar")
		public Pedidos editar(@RequestBody Pedidos pedidos) {
			return service.editar(pedidos);
		}
		
		
		//Eliminar http://localhost:8002/pedido/eliminar
		
		@DeleteMapping("eliminar")
		public Pedidos eliminar (@RequestBody Pedidos pedidos) {
			return service.eliminar(pedidos);
		}
		
		
		//Metodos personalizados
		
		//http://localhost:8002/pedido/buscarPorEstado?estado=pendiente
		
		@PostMapping("buscarPorEstado")
		public List<Pedidos> buscarPorEstado(@Param("estado") String estado){
			return service.buscarPorEstado(estado);
		}
		
		
		//http://localhost:8002/pedido/buscarPorEstatus?estatus=activo
		
		@PostMapping("buscarPorEstatus")
		public List<Pedidos> buscarPorEstatus(@Param("estatus") String estatus){
			return service.buscarPorClasificacion(estatus);
		}
		
		
		

}
