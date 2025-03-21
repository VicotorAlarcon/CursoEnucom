package com.mx.Tienda.Service;

import java.util.List;

import com.mx.Tienda.Entity.Tienda;

public interface ITiendaService {
	
	public Tienda guardar(Tienda tiend);
	
	public Tienda editar(Tienda tiend);
	
	public Tienda eliminar(int idTienda);
	
	public Tienda buscar(int idTienda);
	
	List<Tienda> listar();

}
