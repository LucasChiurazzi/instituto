package ar.edu.teclab.prueba.dto;


import ar.edu.teclab.prueba.entity.Persona;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public abstract class PersonaDto implements Serializable {

    private Integer id;

    private String dni;

    private String nombre;

    private String apellido;

    private Date fechaNac;

    private String sexo;

    private String telefono;

    private String domicilio;

    public PersonaDto() {
    }

    public PersonaDto(Persona persona) {
        this.id = persona.getId();
        this.dni = persona.getDni();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.fechaNac = persona.getFechaNac();
        this.sexo = persona.getSexo();
        this.telefono = persona.getTelefono();
        this.domicilio = persona.getDomicilio();

    }

    public PersonaDto(Integer id, String dni, String nombre, String apellido, Date fechaNac, String sexo, String telefono, String domicilio) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public PersonaDto(String dni, String nombre, String apellido, Date fechaNac, String sexo, String telefono, String domicilio) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
