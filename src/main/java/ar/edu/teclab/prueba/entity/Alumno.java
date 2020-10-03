package ar.edu.teclab.prueba.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Table(name="alumno")
@Entity
@EnableAutoConfiguration
public class Alumno extends Persona {

    private String status;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "alumno"
    )
    private Set<Cursada> cursadas;

    public Set<Cursada> getCursada() {
        return cursadas;
    }

    public void setCursada(Set<Cursada> cursadas) {
        this.cursadas = cursadas;
    }
    public Alumno() {
        super();
    }

    public Alumno(Integer id, String dni, String nombre, String apellido, Date fechanac, String sexo,
                  String telefono, @Size(max = 250) String domicilio, Cursada... cursadas) {
        super(id, dni, nombre, apellido, fechanac, sexo, telefono, domicilio);
        for(Cursada cursada : cursadas)cursada.setAlumno(this);
        this.cursadas = Stream.of(cursadas).collect(Collectors.toSet());

    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
