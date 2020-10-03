package ar.edu.teclab.prueba.repository;

import ar.edu.teclab.prueba.entity.Cursada;
import ar.edu.teclab.prueba.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {


    @Query("SELECT distinct mat "
            + "FROM Cursada c "
            + "INNER JOIN c.materia mat "
            + "INNER JOIN mat.carrera car "
            + "WHERE mat.status = 'ACT' "
            + "AND c.status = 'BAJ' "
            + "AND car.id= :carreraId "
            + "AND mat.id= :materiaId ")
    Materia findMateriaInCursadaByMateriaIdAndCarreraId(@Param("carreraId") Integer carreraId,
                                           @Param("materiaId") Integer materiaId );
}
