package com.mx.Tienda.FeingClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.mx.Tienda.Models.Proveedores;

@FeignClient(
		name = "MS-Proveedores",
		url = "http://localhost:8012",
		path = "/Proveedores"
	)

public interface IProveedoresFeing {
	
	@PostMapping
	public Proveedores save(@RequestBody Proveedores provedor);
	
	@PostMapping ("buscarPorTiendaId/{tiendaId}") 

	public List<Proveedores> getProveedoresById(@PathVariable int tiendaId);

}
