package ar.edu.teclab.prueba.entity;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
@EnableAutoConfiguration
public abstract class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String dni;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    @NotNull
    private String sexo;

    @NotNull
    private String telefono;

    @NotNull
    @Size(max = 250)
    private String domicilio;

    public Persona() {
    }

    public Persona(Integer id, String dni,
                   String nombre, String apellido,
                   Date fechanac, String sexo, String telefono, String domicilio) {
    }

    public Persona(String dni, String nombre,
                   String apellido, Date fechanac,
                   String sexo, String telefono, String domicilio) {
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
