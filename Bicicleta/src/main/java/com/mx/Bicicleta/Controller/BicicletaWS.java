package com.mx.Bicicleta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Bicicleta.Dominio.Bicicleta;
import com.mx.Bicicleta.Servicio.BicicletaServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping (path = "/api/v1/Bici")
public class BicicletaWS {

		//Inyeccion de dependencia del @Service
	@Autowired
	private BicicletaServiceImpl service;
	
	// creacion de endpoints
	
	//Enpoint "listar"
	//URL: http://localhost:8080/api/v1/Bici/listar
	@GetMapping( value = "listar")
	public List<Bicicleta>listar(){
		return service.listar();
	}
	
	
	//Enpoint "Bucacr"
		//URL: http://localhost:8080/api/v1/Bici/buscar/{1}
	@PostMapping(value = "buscar/{idBici}")
		public Bicicleta buscar(@PathVariable int idBici) {
		return service.buscar(idBici);
	}
	
	
	//Enpoint "guardar"
		//URL: http://localhost:8080/api/v1/Bici/guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Bicicleta bici) {  
		// @RequestBody sirve para deserializar el documento json y convertirlo en un objeto java. 
		// @ResponBody sirve para serializar el objeto java y convertilos a json
		service.guardar(bici);
		
	}
	
	//Enpoint "editar"
			//URL: http://localhost:8080/api/v1/Bici/editar
	
	@PutMapping(value = "editar")
	public void editar(@RequestBody Bicicleta bici) {
		service.editar(bici);
	}
	
	
	//Enpoint "eliminar"
			//URL: http://localhost:8080/api/v1/Bici/eliminar/{1}
	
	@DeleteMapping(value = "eliminar/{idBici}")
	public void eliminar(@PathVariable int idBici) {
		service.eliminar(idBici);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
