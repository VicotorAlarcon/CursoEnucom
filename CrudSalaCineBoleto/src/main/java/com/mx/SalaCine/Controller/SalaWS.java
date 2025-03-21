package com.mx.SalaCine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.SalaCine.Entity.Sala;
import com.mx.SalaCine.Service.SalaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController // indicamos que la clase es un cotrolador y recibe solicitudes HTTP y devuelve una respuesta 
@RequestMapping ("/sala")
@CrossOrigin // Evita que tengamos acceso denegado al solicitar informacion al servidor 

public class SalaWS {

	// inyeccion de dependencias
	@Autowired
	private SalaServiceImpl service;
	
	// creacion de end point
	
	
	//Listado http://localhost:8002/sala/listar
	
	@GetMapping("listar")
	public List<Sala> listar(){
		return service.listar();
	}
	
	
	// //Buscar http://localhost:8002/sala/buscar
	
	@PostMapping("buscar")
	public Sala buscar(@RequestBody Sala sala) {
		return service.buscar(sala);
	}
	
	//Guardar http://localhost:8002/sala/guardar
	
	@PostMapping("guardar")
	public Sala guardar(@RequestBody Sala sala) {	
		
		return service.guardar(sala);
	}
	
	
	//Editar http://localhost:8002/sala/editar
	
	@PutMapping ("editar")
	public Sala editar(@RequestBody Sala sala) {
		return service.editar(sala);
	}
	
	//Eliminar http://localhost:8002/sala/eliminar
	
	@DeleteMapping ("eliminar")
	public Sala eliminar(@RequestBody Sala sala) {
		return service.eliminar(sala);
	}
	
	// Metodos personalizados 
	
	//Buscar por categoria 1 http://localhost:8002/sala/buscarPorCategoria1?categoria=tradicional
	@PostMapping ("buscarPorCategoria1")
	public List<Sala> buscarPorCategoria(@Param("categoria") String categoria){
		return service.buscarPorCategoria(categoria);
	}
	
	
	//Buscar por categoria 2 http://localhost:8002/sala/buscarPorCategoria2?categoria=tradicional
	@PostMapping ("buscarPorCategoria2")
	public List<Sala> buscarPorCategoria2(@Param("categoria") String categoria){
		return service.buscarPorCategoria2(categoria);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
