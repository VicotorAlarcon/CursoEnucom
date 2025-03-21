package com.mx.SalaCine.Controller;

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

import com.mx.SalaCine.Entity.Boleto;
import com.mx.SalaCine.Service.BoletoServiceImpl;

@RestController
@RequestMapping ("/Boleto")
@CrossOrigin

public class BoletoWS {
	
	@Autowired
	private BoletoServiceImpl service;
	
	
	
	//listado http://localhost:8002/Boleto/listar
	
	@GetMapping("listar")
			public List<Boleto> listar(){
		return service.listar();
	}
	
	//buscar http://localhost:8002/Boleto/buscar
	
	@PostMapping("buscar")
	public Boleto buscar(@RequestBody Boleto boleto) {
		return service.buscar(boleto);
	}
	
	
	//guardar http://localhost:8002/Boleto/guardar
	@PostMapping("guardar")
	public Boleto guardar (@RequestBody Boleto boleto) {
		return service.guardar(boleto);
	}
	
	//Editar http://localhost:8002/Boleto/editar
	
	@PutMapping("editar")
	public Boleto editar(@RequestBody Boleto beleto) {
		return service.editar(beleto);
	}
	
	
	//Eliminar http://localhost:8002/Boleto/eliminar
	
	@DeleteMapping("eliminar")
	public Boleto eliminar (@RequestBody Boleto boleto) {
		return service.eliminar(boleto);
	}
	
	
	//Metodos personalizados
	
	//http://localhost:8002/Boleto/buscarPorPelicula?nomPelicula=transformers
	
	@PostMapping("buscarPorPelicula")
	public List<Boleto> buscarPorPelicula(@Param("nomPelicula") String nomPelicula){
		return service.buscarPorPelicula(nomPelicula);
	}
	
	
	//http://localhost:8002/Boleto/buscarPorClasificacion?clasificacion=b15
	
	@PostMapping("buscarPorClasificacion")
	public List<Boleto> buscarPorClasificacion(@Param("clasificacion") String clasificacion){
		return service.buscarPorClasificacion(clasificacion);
	}
	
	@GetMapping("buscarPorPelicula2/{nomPelicula}")
	public List<Boleto> buscarPorPelicula2(@PathVariable String nomPelicula){
		return service.buscarPorPelicula2(nomPelicula);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
