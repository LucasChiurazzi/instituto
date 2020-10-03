package ar.edu.teclab.prueba.dto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlumnoDto extends PersonaDto {

    private String status;

    private Set<CursadaDto> cursadaDtos;

    public Set<CursadaDto> getCursada() {
        return cursadaDtos;
    }

    public void setCursada(Set<CursadaDto> cursadaDtos) {
        this.cursadaDtos = cursadaDtos;
    }

    public AlumnoDto() {
        super();
    }

    public AlumnoDto(Integer id, String dni, String nombre, String apellido, Date fechanac, String sexo,
                     String telefono, @Size(max = 250) String domicilio, CursadaDto... cursadaDtos) {
        super(id, dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
        for(CursadaDto cursadaDto : cursadaDtos) cursadaDto.setAlumno(this);
        this.cursadaDtos = Stream.of(cursadaDtos).collect(Collectors.toSet());

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
