package com.mx.MedicosCitas.Service;

import java.util.List;

import com.mx.MedicosCitas.Entity.Citas;



public interface ICitasService {
	public Citas guardar (Citas cita);
	public Citas editar (Citas cita);
	public Citas eliminar (Citas cita);
	public Citas buscar (Citas cita);
	
	public List<Citas>listar();

}
