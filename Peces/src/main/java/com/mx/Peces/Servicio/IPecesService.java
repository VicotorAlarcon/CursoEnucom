package com.mx.Peces.Servicio;

import java.util.List;

import com.mx.Peces.Dominio.Peces;


public interface IPecesService {

public void guardar(Peces pez);
	
	public void editar(Peces pez);

	public void eliminar(int idPez);
	
	public Peces buscar(int idPez);
	
	public List<Peces> listar();
}
