package com.mx.Clientes.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Clientes.Entity.Clientes;
import com.mx.Clientes.Service.ClientesServImpl;



@RestController
@RequestMapping("/Clientes")
@CrossOrigin

public class ClientesWS {

	@Autowired
	private ClientesServImpl service;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Clientes> clientes = service.listar();

		if (clientes.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.status(HttpStatus.OK).body(clientes);

	}

	@PostMapping("/{idCliente}")
	public ResponseEntity<?> buscar(@PathVariable Long idCliente) {
		Clientes cliente = service.buscar(idCliente);

		if (cliente != null)
			return ResponseEntity.status(HttpStatus.OK).body(cliente);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Clientes cliente) {
		Clientes nuevoCliente = service.guardar(cliente);

		if (nuevoCliente != null)

			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Clientes cliente) {
		Clientes aux = service.buscar(cliente.getIdCliente());

		if (aux != null)
			if (service.editar(cliente) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(cliente);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	
	@DeleteMapping
	public ResponseEntity<?> eliminar(@Param("idCliente") Long idCliente) {

		Clientes aux = service.buscar(idCliente);

		//if (aux != null)

			if (aux != null)
				if (service.eliminar(idCliente) != null) {
					return ResponseEntity.status(HttpStatus.OK).body(aux);
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
/*
	@DeleteMapping
	public ResponseEntity<?> eliminar(@Param("idCliente") Long idCliente) {

		Clientes aux = service.buscar(idCliente);

		//if (aux != null)

			if (aux != null)
				if (service.eliminar(idCliente) != null) {
					return ResponseEntity.status(HttpStatus.OK).body(aux);
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	*/
	
	@PostMapping("/tienda/{tiendaId}")
	
	public ResponseEntity<?> buscarPorTiendaId (@PathVariable int tiendaId){
		List<Clientes> clientes = service.byTiendaId(tiendaId);
		
		if(clientes.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
	

}





















