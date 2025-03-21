package com.mx.Proveedores.Service;

import java.util.List;

import com.mx.Proveedores.Entity.Proveedores;

public interface IProveedoresService {
	
	public Proveedores guardar(Proveedores provedor);
	
	public Proveedores editar (Proveedores provedor);
	
	public Proveedores eliminar (Long id);
	
	public Proveedores buscar (Long id);
	
	public List<Proveedores> listar();

}
