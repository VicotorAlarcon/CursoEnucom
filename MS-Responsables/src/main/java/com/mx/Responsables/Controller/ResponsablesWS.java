package com.mx.Responsables.Controller;

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

import com.mx.Responsables.Entity.Responsables;
import com.mx.Responsables.Service.ResponsablesServImpl;


@RestController
@RequestMapping ("/Responsables")
@CrossOrigin
public class ResponsablesWS {

	@Autowired
	private ResponsablesServImpl service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Responsables> responsable = service.listar();
		
		if(responsable.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(responsable);
	}
	
	@PostMapping ("/{idResponsable}")
	public ResponseEntity<?> buscar(@PathVariable Long idResponsable){
		Responsables responsable = service.buscar(idResponsable);
		if (responsable != null)
			return ResponseEntity.status(HttpStatus.OK).body(responsable);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Responsables responsable) {
		Responsables nuevoRes = service.guardar(responsable);

		if (nuevoRes != null)

			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRes);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Responsables responsable) {
		Responsables aux = service.buscar(responsable.getIdResponsable());

		if (aux != null)
			if (service.editar(responsable) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(responsable);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
	
	@DeleteMapping
	public ResponseEntity<?> eliminar(@Param("idResponsable") Long idResponsable) {

		Responsables aux = service.buscar(idResponsable);

			if (aux != null)
				if (service.eliminar(idResponsable) != null) {
					return ResponseEntity.status(HttpStatus.OK).body(aux);
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}
	
@PostMapping("/Responsables/{veterinariaId}")
	
	public ResponseEntity<?> buscarPorTiendaId (@PathVariable int veterinariaId){
		List<Responsables> clientes = service.byVeterinariaId(veterinariaId);
		
		if(clientes.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}
	
	
}


































