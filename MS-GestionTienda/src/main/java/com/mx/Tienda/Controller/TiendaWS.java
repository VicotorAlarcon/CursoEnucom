package com.mx.Tienda.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Service.TiendaServiceImpl;

@RestController
@RequestMapping ("/Tienda")

public class TiendaWS {
	
	@Autowired
	private TiendaServiceImpl service;
	
	//Listar
	@GetMapping
	public ResponseEntity<?> ListarTienda(){
		List<Tienda> tiend = service.listar();
		
		if(tiend.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(tiend);
		}
	}
	
	//buscar
	@PostMapping("/{idTienda}")
	public ResponseEntity<?> ObtenerTienda(@PathVariable int idTienda){
		Tienda tiend = service.buscar(idTienda);
		if (tiend != null) {
			return ResponseEntity.ok(tiend);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Guardar
	@PostMapping
	public ResponseEntity<?> guardarTienda(@RequestBody Tienda tiend){
		return ResponseEntity.ok(service.guardar(tiend));
	}
	
	//Actualizar
	@PutMapping
	public ResponseEntity<?> actualizarTienda (@RequestBody Tienda tiend){
		Tienda tiendaBD = service.buscar(tiend.getIdTienda());
		if(tiendaBD != null) {
			return ResponseEntity.ok(service.editar(tiend));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//eliminar
	
	@DeleteMapping("/{idTienda}")
	public ResponseEntity<?> eliminarTienda(@PathVariable int idTienda){
		Tienda tiend = service.buscar(idTienda);
		if( tiend != null) {
			service.eliminar(idTienda);
			return ResponseEntity.ok(tiend);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	// end 
	//http://localhost:8014/Tienda/Clientes
	
	@PostMapping ("/Clientes")
	public ResponseEntity<?> guardarCliente(@RequestBody Clientes cliente){
		Clientes nuevoCliente = service.saveCliente(cliente);
		if(nuevoCliente == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
	}
	
	@PostMapping ("/Clientes/{tiendaId}")
	public ResponseEntity<?> obtenerClientes(@PathVariable int tiendaId){
		List<Clientes> clientes = service.getClientes(tiendaId);
		
		if(clientes.isEmpty())
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(clientes);		
		
	}
	
	
	//http:localhost:8014/Tienda/Productos
	
	@PostMapping ("/Productos")
	
	public ResponseEntity<?> guardarProductos(@RequestBody Productos productos){
		Productos nuevoProducto = service.saveProductos(productos);
		if(nuevoProducto == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
		
	}
	
	
	@GetMapping ("/Productos/{tiendaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int tiendaId){
		List<Productos> productos = service.getProductos(tiendaId);
		if(productos.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(productos);
	}
	
	
	//Guardar Proveedores
	//http:localhost:8014/Tienda/Proveedores
	
	@PostMapping ("/Proveedores")
	public ResponseEntity<?> guardarProveedor(@RequestBody Proveedores provedor){
		Proveedores nuevoProvedor = service.saveProveedor(provedor);
		if(nuevoProvedor == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProvedor);
	}
	
	@PostMapping("/Proveedores/{tiendaId}")
	public ResponseEntity<?> obtenerProveedores (@PathVariable int tiendaId){
		List<Proveedores> proveedores = service.getProveedores(tiendaId);
		if(proveedores.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	return ResponseEntity.status(HttpStatus.OK).body(proveedores);	
	}
	
	
	
	//obtener todos los modulos
	////http:localhost:8014/Tienda/todo/{tiendaId}
	@GetMapping("/todo/{tiendaId}")
	public ResponseEntity<?> obtenerTodosLosModulos(@PathVariable int tiendaId){
		Map<String, Object> modulos = service.obtenerTodosLosModulos(tiendaId);
		return ResponseEntity.status(HttpStatus.OK).body(modulos);
		
		
	}

}





















