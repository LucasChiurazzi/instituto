package ar.edu.teclab.prueba.service;

import ar.edu.teclab.prueba.Config.ConstantConfig;
import ar.edu.teclab.prueba.converter.CarreraConverter;
import ar.edu.teclab.prueba.dto.CarreraDto;
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.entity.Cursada;
import ar.edu.teclab.prueba.entity.Materia;
import ar.edu.teclab.prueba.exceptions.ConflictException;
import ar.edu.teclab.prueba.exceptions.ResourceNotFoundException;
import ar.edu.teclab.prueba.repository.CarreraRepository;
import ar.edu.teclab.prueba.repository.CursadaRepository;
import ar.edu.teclab.prueba.repository.MateriaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class CarreraService {

    private static final Log LOG = LogFactory.getLog(PruebaService.class);

    @Resource
    CarreraRepository carreraRepository;

    @Resource
    CursadaRepository cursadaRepository;

    @Resource
    CarreraConverter carreraConverter;

    @Resource
    MateriaRepository materiaRepository;

    //crea una carrera
    public CarreraDto createCarrera(CarreraDto carreraDto) throws Exception {
        if(carreraDto==null){
            throw  new ConflictException("Por favor ingrese datos para guardar la carrera");
        }
        try {
            Carrera carrera = carreraConverter.toEntity(carreraDto);
            Carrera save = carreraRepository.save(carrera);
            carreraDto.setId(save.getId());
        } catch (Exception e) {
            LOG.error("Error", e);
        }
        return carreraDto;
    }

    //obetener carrera por id
    public CarreraDto getCarreraById(Integer carreraId){
     Carrera carrera = carreraRepository.findOne(carreraId);
    if(carrera== null){
        throw new ResourceNotFoundException("No se econtro la carrera indicada");
    }
        return carreraConverter.toDto(carrera);

    }

    //obtener todas las carreras
    public List<CarreraDto> getAllCarreraDto(){
        List<CarreraDto> carreraDtos = carreraConverter.toDtoList(carreraRepository.findAll());
        return carreraDtos;
    }

    //obtener todas las carreras activas
    public List<CarreraDto> getAllActiveCarreraDto(){
        List<CarreraDto> carreraDtos = carreraConverter.toDtoList(carreraRepository.findAllActiveCarreras());
        return carreraDtos;
    }

    //Borrar carreras mientras no tengas cursada con alumnos
    public HashMap<String, String> deleteCarrera(Integer carreraId){
        // no se debe poder borrar una carrera que tenga materias y cursadas
        HashMap<String, String> result= new HashMap<>();
        List<Cursada> cursadasList = cursadaRepository.
                findAllCursadaActivesByCarreraId(carreraId);
        if(cursadasList.isEmpty()){
            Carrera carrera = carreraRepository.findOne(carreraId);
            if(carrera!=null){
                carrera.setStatus(ConstantConfig.STATUS_BAJA);
                carreraRepository.save(carrera);
                result.put("Resultado", "Ok");
            }else{
                throw new ResourceNotFoundException("No se econtro la carrera indicada");
            }
        }else{
            throw new ConflictException("No se puede eliminar una carrera con cursadas activas");
        }
        return  result;
    }

    //actualizar carrera
    public CarreraDto updateCarrera(CarreraDto carreraDto) throws Exception {
        if(carreraDto==null){
            throw  new ConflictException("Por favor ingrese datos para guardar la carrera");
        }
        Carrera entity = carreraRepository.getOne(carreraDto.getId());
        entity.setStatus(carreraDto.getStatus());
        entity.setName(carreraDto.getName());
        entity.setCode(carreraDto.getCode());
        entity.setId(carreraDto.getId());
        Carrera save = carreraRepository.save(entity);
        carreraDto.setId(save.getId());
        return carreraDto;
    }

    //agregar materia a carrera
    public HashMap<String, String> addMateria(Integer carreraId, Integer materiaId){
        HashMap<String, String> result= new HashMap<>();
        Carrera carrera = carreraRepository.findOne(carreraId);
        if(carrera==null || carrera.getStatus().equalsIgnoreCase(ConstantConfig.STATUS_BAJA)){
            throw  new ConflictException("Los datos de la carrera no son validos");
        }
        Materia materia = materiaRepository.getOne(materiaId);
        if(materia==null || materia.getStatus().equalsIgnoreCase(ConstantConfig.STATUS_BAJA)){
            throw  new ConflictException("Los datos de la materia no son validos");
        }
        materia.setCarrera(carrera);
        materiaRepository.save(materia);
        result.put("Resultado", "Ok");
        return  result;
    }

    //borrar materia de carrera mientras no tenga cursada activa
    public HashMap<String, String> deleteMateriaFromCarrera(Integer carreraId, Integer materiaId){
        HashMap<String, String> result= new HashMap<>();
        Carrera carrera = carreraRepository.findOne(carreraId);
        if(carrera==null || carrera.getStatus().equalsIgnoreCase(ConstantConfig.STATUS_BAJA)){
            throw  new ConflictException("Los datos de la carrera no son validos");
        }
        Materia materia = materiaRepository.findMateriaInCursadaByMateriaIdAndCarreraId(carreraId, materiaId);
        if(materia!=null){
            materia.setCarrera(null);
        }else{
            throw  new ConflictException("Solo se pueden eliminar materias con cursadas inactivas");
        }
        result.put("Resultado", "Ok");
        return  result;
    }


}
