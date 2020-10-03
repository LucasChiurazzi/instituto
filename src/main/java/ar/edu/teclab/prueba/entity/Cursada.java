package ar.edu.teclab.prueba.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@EnableAutoConfiguration
public class Cursada implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "alumno_id", nullable=false)
    private Alumno alumno;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "materia_id", nullable=false)
    private Materia materia;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaCursada;

    private Double nota;

    private String status;

    public Cursada() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
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
        if (!(o instanceof Cursada)) return false;
        Cursada that = (Cursada) o;
        return Objects.equals(materia.getId(), that.materia.getId()) &&
                Objects.equals(alumno.getId(), that.alumno.getId()) &&
                Objects.equals(fechaCursada, that.fechaCursada) &&
                Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materia.getId(), alumno.getId(), fechaCursada, nota);
    }







}

