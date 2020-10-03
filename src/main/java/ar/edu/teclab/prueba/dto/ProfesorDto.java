package ar.edu.teclab.prueba.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;

public class ProfesorDto extends PersonaDto {

	private String status;

	public ProfesorDto() {
		super();
		
	}
	public ProfesorDto(String dni, String nombre, String apellido, Date fechanac, String sexo,
					   String telefono, @Size(max = 250) String domicilio) {
		super( dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		 
	}

	public ProfesorDto(Integer id, String dni, String nombre, String apellido, Date fechanac, String sexo,
					   String telefono, @Size(max = 250) String domicilio) {
		super(id,  dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		 
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
