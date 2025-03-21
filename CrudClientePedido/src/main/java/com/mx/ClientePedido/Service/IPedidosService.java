package com.mx.ClientePedido.Service;

import java.util.List;

import com.mx.ClientePedido.Entity.Pedidos;



public interface IPedidosService {
	
	public Pedidos guardar (Pedidos pedidos);
	public Pedidos editar (Pedidos pedidos);
	public Pedidos eliminar (Pedidos pedidos);
	public Pedidos buscar (Pedidos pedidos);
	
	public List<Pedidos>listar();
}

