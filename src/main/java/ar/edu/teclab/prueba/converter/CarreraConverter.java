package ar.edu.teclab.prueba.converter;

import ar.edu.teclab.prueba.dto.CarreraDto;
import ar.edu.teclab.prueba.entity.Carrera;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CarreraConverter extends GenericConverter<CarreraDto, Carrera> {

	@Resource
	MateriaConverter materiaConverter;

	@Override
	public CarreraDto toDto(Carrera entity) {
		CarreraDto dto= new CarreraDto();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		if(entity.getMateriaList()!=null) {
			dto.setMateriaDtoList(materiaConverter.toDtoList(entity.getMateriaList()));
		}
		return dto;
	}

	@Override
	public Carrera toEntity(CarreraDto dto) throws Exception {
		Carrera entity= new Carrera();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setStatus(dto.getStatus());
		if(dto.getMateriaDtoList()!=null) {
			entity.setMateriaList(materiaConverter.toEntityList(dto.getMateriaDtoList()));
		}
		return entity;
	}
}
