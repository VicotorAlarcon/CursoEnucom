package com.mx.Productos.Entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PRODUCTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_PRODUCTO")
	@SequenceGenerator(name = "SEQ_ID_PRODUCTO", sequenceName = "S_ID_PRODUCTO", allocationSize = 1)
	private Long idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private int stock;
	@Column(name = "FECHA_CREACION", columnDefinition = "DATE")
	private Date fechaCreacion;
	private int tiendaId;
	//@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")

	public Long getIdProducto() {
		return idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public String getFechaCreacion() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		return sdf.format(fechaCreacion);
	}

}
/*
 * ID_PRODUCTO NUMBER, NOMBRE NVARCHAR2 (100), DESCRIPCION NVARCHAR2 (150),
 * PRECIO NUMBER (12, 2), STOCK NUMBER, FECHA_CREACION DATE,
 */