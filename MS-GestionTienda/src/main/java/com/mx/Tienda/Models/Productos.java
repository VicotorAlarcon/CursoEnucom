package com.mx.Tienda.Models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data

public class Productos {

	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private int stock;
	//@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fechaCreacion;
	private int tiendaId;
}