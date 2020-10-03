package ar.edu.teclab.prueba.repository;

import ar.edu.teclab.prueba.entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Override
    Carrera findOne(Integer integer);

    @Query("SELECT c "
            + "FROM Carrera c "
            + "WHERE c.status = 'ACT' ")
    List<Carrera> findAllActiveCarreras();


}


