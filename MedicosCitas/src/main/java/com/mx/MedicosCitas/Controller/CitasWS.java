package com.mx.MedicosCitas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.MedicosCitas.Entity.Citas;
import com.mx.MedicosCitas.Service.CitasServiceImpl;



@RestController
@RequestMapping ("/Citas")
@CrossOrigin

public class CitasWS {
	
	@Autowired
	private CitasServiceImpl service;
	
	
	
	//listado http://localhost:8002/Citas/listar
	
	@GetMapping("listar")
			public List<Citas> listar(){
		return service.listar();
	}
	
	//buscar http://localhost:8002/Citas/buscar
	
	@PostMapping("buscar")
	public Citas buscar(@RequestBody Citas cita) {
		return service.buscar(cita);
	}
	
	
	//guardar http://localhost:8002/Citas/guardar
	@PostMapping("guardar")
	public Citas guardar (@RequestBody Citas boleto) {
		return service.guardar(boleto);
	}
	
	//Editar http://localhost:8002/Citas/editar
	
	@PutMapping("editar")
	public Citas editar(@RequestBody Citas cita) {
		return service.editar(cita);
	}
	
	
	//Eliminar http://localhost:8002/Citas/eliminar
	
	@DeleteMapping("eliminar")
	public Citas eliminar (@RequestBody Citas cita) {
		return service.eliminar(cita);
	}
	
	
	//Metodos personalizados
	
	//http://localhost:8002/Citas/buscarPorMotivo?motivo=revisión
	
	@PostMapping("buscarPorMotivo")
	public List<Citas> buscarPorMotivo(@Param("motivo") String motivo){
		return service.buscarPorMotivo(motivo);
	}
	
	
	//http://localhost:8002/Citas/buscarPorPacienteNombre?pacienteNombre=pedro
	
	@PostMapping("buscarPorPacienteNombre")
	public List<Citas> buscarPorPacienteNombre(@Param("pacienteNombre") String pacienteNombre){
		return service.buscarPorPacienteNombre(pacienteNombre);
	}
	
	//http://localhost:8002/Citas/buscarPorPacienteNombre2/buscar/pedro
	@GetMapping("buscarPorPacienteNombre2/{pacienteNombre}")
	public List<Citas> buscarPorPacienteNombre2(@PathVariable String pacienteNombre){
		return service.buscarPorPacienteNombre2(pacienteNombre);
	}

}
