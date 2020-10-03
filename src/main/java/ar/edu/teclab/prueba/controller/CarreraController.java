package ar.edu.teclab.prueba.controller;

import ar.edu.teclab.prueba.dto.CarreraDto;
import ar.edu.teclab.prueba.service.CarreraService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/instituto")
@CrossOrigin(origins = "*")
public class CarreraController {

    @Resource
    CarreraService carreraService;

//crear carrera
@PostMapping("/carrera")
public CarreraDto crearCarrera( @RequestBody @Valid CarreraDto carreraDto) throws Exception {
    return carreraService.createCarrera(carreraDto);
}

//borrar carrera
@DeleteMapping("/delete/carrera/{carreraId}")
public HashMap<String, String> deleteCarrera(@PathVariable Integer carreraId)  {
    return carreraService.deleteCarrera(carreraId);
}

//modificar Carrera
@PutMapping("/update/carrera")
public CarreraDto modificarCarrera( @RequestBody @Valid CarreraDto carreraDto) throws Exception {
    return carreraService.updateCarrera(carreraDto);
}

//agregar materias
@PutMapping("/add/carrera/{carreraId}/materia/{materiaId}")
public HashMap<String, String> agregarMateriaEnCarrera(@PathVariable Integer carreraId,
                                                       @PathVariable Integer materiaId) {
    return carreraService.addMateria(carreraId, materiaId);
}

//sacar materias
@PutMapping("/delete/carrera/{carreraId}/materia/{materiaId}")
public HashMap<String, String> sacarMateriaDeCarrera(@PathVariable Integer carreraId,
                                                     @PathVariable Integer materiaId) {
    return carreraService.deleteMateriaFromCarrera(carreraId, materiaId);
}

 //listar carreras
 @GetMapping("/carreras")
 public List<CarreraDto> obtenerCarreras() {
     return carreraService.getAllCarreraDto();
 }

 //listar carreras activas
 @GetMapping("/active/carreras")
 public List<CarreraDto> obtenerCarrerasActivas() {
     return carreraService.getAllActiveCarreraDto();
 }


 //traer una carrera
 @GetMapping("/carrera/{carreraId}")
 public CarreraDto getCarreraById(@PathVariable Integer carreraId) {
        return carreraService.getCarreraById(carreraId);
    }

}
