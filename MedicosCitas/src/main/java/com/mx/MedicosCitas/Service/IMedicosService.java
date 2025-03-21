package com.mx.MedicosCitas.Service;

import java.util.List;

import com.mx.MedicosCitas.Entity.Medicos;



public interface IMedicosService {
	
	public Medicos guardar(Medicos medico);
	public Medicos editar(Medicos medico);
	public Medicos eliminar(Medicos medico);
	public Medicos buscar(Medicos medico);
	
	public List<Medicos> listar();

}
