package com.mx.Peces.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Peces.Dominio.Peces;
import com.mx.Peces.Servicio.PecesServiceImpl;

@RestController
@RequestMapping (path = "/api/v1/Pez")
public class PecesWS {
	
	@Autowired
	private PecesServiceImpl service;
	
	
	// Creacion de EndPoints
	
	
	//Listar
	// URL: http://localhost:8001/api/v1/Pez/listar
    @GetMapping(value = "listar")
    public List<Peces>listar(){
    	return service.listar();
    }
	
    
    //Buscar
    // URL: http://localhost:8001/api/v1/Pez/buscar/{1}
    
    @PostMapping (value = "buscar/{idPez}")
    public Peces buscar(@PathVariable int idPez) {
    	return service.buscar(idPez);
    }
  
    
    // "Guardar"
    // URL: http://localhost:8001/api/v1/Pez/guardar
    @PostMapping (value = "guardar")
    public void guardar (@RequestBody Peces pez) {
    	service.guardar(pez);
    }
    
    
    // Editar
    
    //URL: http://localhost:8001/api/v1/Pez/editar
    
    @PutMapping (value = "editar")
    public void editar (@RequestBody Peces pez) {
    	service.editar(pez);
    }
    
    //Eliminar
    //URL: http://localhost:8001/api/v1/Pez/eliminar/{1}
    @DeleteMapping (value = "eliminar/{idPez}")
    public void eliminar (@PathVariable int idPez){
    	service.eliminar(idPez);
    	
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
