package ar.edu.teclab.prueba.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@EnableAutoConfiguration
@Table(name="profesor")
public class Profesor extends Persona {

	private String status;

	public Profesor() {
		super();
		
	}
	public Profesor( String dni, String nombre, String apellido, Date fechanac, String sexo,
			String telefono, @Size(max = 250) String domicilio) {
		super( dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
		 
	}

	public Profesor(Integer id, String dni, String nombre, String apellido, Date fechanac, String sexo,
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
