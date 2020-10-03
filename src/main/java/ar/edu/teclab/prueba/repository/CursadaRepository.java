package ar.edu.teclab.prueba.repository;

import ar.edu.teclab.prueba.entity.Cursada;
import ar.edu.teclab.prueba.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CursadaRepository extends JpaRepository<Cursada, Integer> {

    @Query("SELECT c "
            + "FROM Cursada c "
            + "INNER JOIN c.alumno alum "
            + "INNER JOIN c.materia mat "
            + "INNER JOIN mat.carrera car "
            + "WHERE mat.status = 'ACT' "
            + "AND c.status = 'ACT' "
            + "AND alum.status= 'ACT' "
            + "AND car.id= :carreraId ")
    List<Cursada> findAllCursadaActivesByCarreraId(@Param("carreraId") Integer carreraId);
}
