package com.mx.Tienda.FeingClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Clientes;

@FeignClient(
			name = "MS-Clientes",
			url = "http://localhost:8013",
			path = "/Clientes"
		)
public interface ICientesFeing {
	
	//Declaracion de los controladores del micro servicio MS-Clientes
	
	@PostMapping
	public Clientes save(@RequestBody Clientes cliente);
	
	@PostMapping ("/tienda/{tiendaId}")

	public List<Clientes> getClientesByTiendaId(@PathVariable int tiendaId);
}
