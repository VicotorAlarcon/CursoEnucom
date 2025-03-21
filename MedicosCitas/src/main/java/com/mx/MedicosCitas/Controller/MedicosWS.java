package com.mx.MedicosCitas.Controller;

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

import com.mx.MedicosCitas.Entity.Medicos;
import com.mx.MedicosCitas.Service.MedicosServiceImpl;




@RestController // indicamos que la clase es un cotrolador y recibe solicitudes HTTP y devuelve una respuesta 
@RequestMapping ("/Medicos")
@CrossOrigin // Evita que tengamos acceso denegado al solicitar informacion al servidor 

public class MedicosWS {
	
	@Autowired
	private MedicosServiceImpl service;
	
	
	//http://localhost:8002/Medicos/listar
	@GetMapping("listar")
	public List<Medicos> listar(){
		return service.listar();
	}
	
	
	// //Buscar http://localhost:8002/Medicos/buscar
	
	@PostMapping("buscar")
	public Medicos buscar(@RequestBody Medicos medico) {
		return service.buscar(medico);
	}
	
	//Guardar http://localhost:8002/Medicos/guardar
	
	@PostMapping("guardar")
	public Medicos guardar(@RequestBody Medicos medico) {	
		
		return service.guardar(medico);
	}
	
	
	//Editar http://localhost:8002/Medicos/editar
	
	@PutMapping ("editar")
	public Medicos editar(@RequestBody Medicos medico) {
		return service.editar(medico);
	}
	
	//Eliminar http://localhost:8002/Medicos/eliminar
	
	@DeleteMapping ("eliminar")
	public Medicos eliminar(@RequestBody Medicos medico) {
		return service.eliminar(medico);
	}
	
	// Metodos personalizados 
	
	//Buscar por categoria 1 http://localhost:8002/Medicos/buscarPorEspecialidad1?especialidad=Cardiología
	@PostMapping ("buscarPorEspecialidad1")
	public List<Medicos> buscarPorEspecialidad(@Param("especialidad") String especialidad){
		return service.buscarPorEspecialidad(especialidad);
	}
	
	
		
	
	
	
	
	
	
	
	

}
