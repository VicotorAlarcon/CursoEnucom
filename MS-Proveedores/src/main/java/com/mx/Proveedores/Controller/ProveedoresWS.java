package com.mx.Proveedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Proveedores.Entity.Proveedores;
import com.mx.Proveedores.Service.ProveedoresServiceImpl;

@RestController
@RequestMapping ("/Proveedores")

public class ProveedoresWS {
	
	@Autowired
	private ProveedoresServiceImpl service;
	
	//EndPoint Listar
	
	@GetMapping 
	public ResponseEntity<?> listaProveedor(){
		List<Proveedores> provedor = service.listar();
		if(provedor.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(provedor);
		}
	}
	
	//End Point buscar
	
	@PostMapping ("/{id}")
	public ResponseEntity<?> obtenerProveedor(@PathVariable Long id){
		Proveedores provedor = service.buscar(id);
		if(provedor != null) {
			return ResponseEntity.ok(provedor);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Guardar Proveedor
	
	@PostMapping
	public ResponseEntity<?> guardarProveedores(@RequestBody Proveedores provedor){
		
		return ResponseEntity.ok(service.guardar(provedor));
	}
	
	
	//Actualizar producto
		@PutMapping
		public ResponseEntity<?> actualizarProveedor(@RequestBody Proveedores provedor){
			Proveedores provedorBD = service.buscar(provedor.getId());
			if(provedorBD != null) {
				
				return ResponseEntity.ok(service.editar(provedor));
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		
		//Eliminar Porducto
		@DeleteMapping("{id}")
		public ResponseEntity<?> eliminarProveedores(@PathVariable Long id){
			Proveedores provedor = service.buscar(id);
			if(provedor != null) {
				service.eliminar(id);	
				return ResponseEntity.ok(provedor);
			}else {
				return ResponseEntity.notFound().build();
			}
			
			}
		

		@PostMapping("buscarPorTiendaId/{tiendaId}") 
		public List<Proveedores> buscarPorTiendaId(@PathVariable int tiendaId){
			return service.buscarPorTiendaId(tiendaId);
		}
		
	
	

}

















