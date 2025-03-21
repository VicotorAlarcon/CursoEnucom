package com.mx.Proveedores.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "PROVEEDORES")
@Data

public class Proveedores {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ_ID")
	@SequenceGenerator(name = "SEQ_ID", sequenceName = "S_ID", allocationSize = 1)
	private Long id;
	private String nombre;
	private Long contacto;
	private String empresa;
	private int tiendaId;

}
