package com.mx.ClientePedido.Service;

import java.util.List;

import com.mx.ClientePedido.Entity.Clientes;



public interface IClientesService {
	
	public Clientes guardar(Clientes clientes);
	public Clientes editar(Clientes clientes);
	public Clientes eliminar(Clientes clientes);
	public Clientes buscar(Clientes clientes);
	
	public List<Clientes> listar();

}
