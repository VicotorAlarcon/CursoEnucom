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

import com.mx.ClientePedido.Entity.Clientes;
import com.mx.ClientePedido.Service.ClientesServiceImpl;


@RestController // indicamos que la clase es un cotrolador y recibe solicitudes HTTP y devuelve una respuesta 
@RequestMapping ("/cliente")
@CrossOrigin // Evita que tengamos acceso denegado al solicitar informacion al servidor 

public class ClientesWS {
	
	// inyeccion de dependencias
		@Autowired
		private ClientesServiceImpl service;
		
		// creacion de end point
		
		
		//Listado http://localhost:8002/cliente/listar
		
		@GetMapping("listar")
		public List<Clientes> listar(){
			return service.listar();
		}
		
		
		// //Buscar http://localhost:8002/cliente/buscar
		
		@PostMapping("buscar")
		public Clientes buscar(@RequestBody Clientes cliente) {
			return service.buscar(cliente);
		}
		
		//Guardar http://localhost:8002/cliente/guardar
		
		@PostMapping("guardar")
		public Clientes guardar(@RequestBody Clientes clientes) {	
			
			return service.guardar(clientes);
		}
		
		
		//Editar http://localhost:8002/cliente/editar
		
		@PutMapping ("editar")
		public Clientes editar(@RequestBody Clientes clientes) {
			return service.editar(clientes);
		}
		
		//Eliminar http://localhost:8002/cliente/eliminar
		
		@DeleteMapping ("eliminar")
		public Clientes eliminar(@RequestBody Clientes clientes) {
			return service.eliminar(clientes);
		}
		
		// Metodos personalizados 
		
		//Buscar por nombre 1 http://localhost:8002/cliente/buscarPorNombre1?nombre=juan
		@PostMapping ("buscarPorNombre1")
		public List<Clientes> buscarPorNombre(@Param("nombre") String nombre){
			return service.buscarPorNombre(nombre);
		}
		
		
		//Buscar por categoria 2 http://localhost:8002/sala/buscarPorCategoria2?categoria=tradicional
		@PostMapping ("buscarPorNombre2")
		public List<Clientes> buscarPorNombre2(@Param("nombre") String nombre){
			return service.buscarPorNombre2(nombre);
		}
		

}
