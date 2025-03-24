package com.mx.Responsables.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "Responsables")
@Data
public class Responsables {
	
	@Id
	private Long idResponsable;
	private String nombre;
	private Long contacto;
	private int veterinariaId;
	
	
	
	
	
	/*
	
		    ID_RESPONSABLE NUMBER,
		    NOMBRE NVARCHAR2 (100),
		    CONTACTO NUMBER,
		    VETERINARIA_ID NUMBER,
		    CONSTRAINT ID_RESPONSABLE_PK PRIMARY KEY (ID_RESPONSABLE)

		);
*/
}
