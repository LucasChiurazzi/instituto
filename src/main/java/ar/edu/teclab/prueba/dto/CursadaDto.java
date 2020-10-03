package ar.edu.teclab.prueba.dto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CursadaDto {

    private Integer id;

    private AlumnoDto alumnoDto;

    private MateriaDto materiaDto;

    private Date fechaCursada;

    private Double nota;

    private String status;

    public CursadaDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AlumnoDto getAlumno() {
        return alumnoDto;
    }

    public void setAlumno(AlumnoDto alumnoDto) {
        this.alumnoDto = alumnoDto;
    }

    public MateriaDto getMateria() {
        return materiaDto;
    }

    public void setMateria(MateriaDto materiaDto) {
        this.materiaDto = materiaDto;
    }

    public Date getFechaCursada() {
        return fechaCursada;
    }

    public void setFechaCursada(Date fechaCursada) {
        this.fechaCursada = fechaCursada;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursadaDto)) return false;
        CursadaDto that = (CursadaDto) o;
        return Objects.equals(materiaDto.getId(), that.materiaDto.getId()) &&
                Objects.equals(alumnoDto.getId(), that.alumnoDto.getId()) &&
                Objects.equals(fechaCursada, that.fechaCursada) &&
                Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materiaDto.getId(), alumnoDto.getId(), fechaCursada, nota);
    }







}

