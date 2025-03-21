package com.mx.Bicicleta.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "BICICLETA")

public class Bicicleta {

	/*
	 * CREATE TABLE BICICLETA( ID_BICI NUMBER,
	 *  MARCA NVARCHAR2(50),
	 *  MODELO NVARCHAR2(50),
	 *  TIPO NVARCHAR2(30), 
	 *  COLOR NVARCHAR2(30), 
	 *  RODADA NUMBER,
	 * MATERIAL NVARCHAR2(30),
	 * PRECIO NUMBER(10, 2), -- Ej. 12345678.90 CONSTRAINT
	 * ID_BICI_PK PRIMARY KEY (ID_BICI) );
	 * 
	 * INSERT INTO BICICLETA VALUES (1, 'Trek', 'Marlin 7', 'Montaña', 'Rojo', 29,
	 * 'Aluminio', 14999.99); INSERT INTO BICICLETA VALUES (2, 'Specialized',
	 * 'Rockhopper', 'Montaña', 'Negro', 27, 'Aluminio', 13499.50); INSERT INTO
	 * BICICLETA VALUES (3, 'Giant', 'Talon 2', 'Montaña', 'Azul', 29, 'Aluminio',
	 * 12500.00); INSERT INTO BICICLETA VALUES (4, 'Scott', 'Speedster 10', 'Ruta',
	 * 'Blanco', 28, 'Carbono', 28999.99); INSERT INTO BICICLETA VALUES (5, 'BMC',
	 * 'Teammachine SLR01', 'Ruta', 'Negro', 28, 'Carbono', 49999.00); INSERT INTO
	 * BICICLETA VALUES (6, 'Cannondale', 'Trail 5', 'Montaña', 'Verde', 27,
	 * 'Aluminio', 11500.75); INSERT INTO BICICLETA VALUES (7, 'Orbea', 'Alma M50',
	 * 'Montaña', 'Naranja', 29, 'Carbono', 18500.99); INSERT INTO BICICLETA VALUES
	 * (8, 'Merida', 'Scultura 400', 'Ruta', 'Gris', 28, 'Aluminio', 21999.25);
	 * INSERT INTO BICICLETA VALUES (9, 'Fuji', 'Jari 2.3', 'Gravel', 'Verde', 28,
	 * 'Acero', 17999.00); INSERT INTO BICICLETA VALUES (10, 'GT', 'Aggressor Pro',
	 * 'Montaña', 'Amarillo', 27, 'Aluminio', 9999.99);
	 * 
	 * 
	 */

	@Id
	@Column (name = "ID_BICI", columnDefinition = "NUMBER")
	private int idBici;
	@Column (name = "MARCA" , columnDefinition = "NVARCHAR2 (50)")
	private String marca;
	@Column (name = "MODELO" , columnDefinition = "NVARCHAR2 (50)")
	private String modelo;
	@Column (name = "TIPO" , columnDefinition = "NVARCHAR2 (30)")
	private String tipo;
	@Column (name = "COLOR" , columnDefinition = "NVARCHAR2 (30)")
	private String color;
	@Column (name = "RODADA" , columnDefinition = "NUMBER")
	private int rodada;
	@Column (name = "MATERIAL" , columnDefinition = "NVARCHAR2 (30)")
	private String material;
	@Column (name = "PRECIO" , columnDefinition = "NUMBER (10, 2)")
	
	private double precio;

	public Bicicleta() {
	}

	public Bicicleta(int idBici, String marca, String modelo, String tipo, String color, int rodada, String material,
			double precio) {
		this.idBici = idBici;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.color = color;
		this.rodada = rodada;
		this.material = material;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Bicicleta [idBici=" + idBici + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", color="
				+ color + ", rodada=" + rodada + ", material=" + material + ", precio=" + precio + "]";
	}

	public int getIdBici() {
		return idBici;
	}

	public void setIdBici(int idBici) {
		this.idBici = idBici;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
