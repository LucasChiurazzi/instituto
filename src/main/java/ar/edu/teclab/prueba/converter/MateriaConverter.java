package ar.edu.teclab.prueba.converter;

import ar.edu.teclab.prueba.dto.MateriaDto;
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.entity.Materia;
import ar.edu.teclab.prueba.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MateriaConverter extends GenericConverter<MateriaDto, Materia> {

	@Resource
	ProfesorConverter profesorConverter;

	@Resource
	CarreraConverter carreraConverter;

	@Resource
	CarreraRepository carreraRepository;

	@Override
	public MateriaDto toDto(Materia entity) {
		MateriaDto dto= new MateriaDto();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setCarreraName(entity.getCarrera()!=null?entity.getCarrera().getName():null);
		dto.setCarreraId(entity.getCarrera()!=null?entity.getCarrera().getId():null);
		dto.setProfesorDto(profesorConverter.toDto(entity.getProfesor()));
		return dto;
	}

	@Override
	public Materia toEntity(MateriaDto dto) throws Exception {
		Materia entity= new Materia();
		entity.setCode(entity.getCode());
		entity.setName(entity.getName());
		entity.setStatus(dto.getStatus());
		Integer carreraId = dto.getCarreraId();
		if(carreraId !=null) {
			entity.setCarrera(carreraRepository.getOne(carreraId));
		}
		entity.setProfesor(profesorConverter.toEntity(dto.getProfesorDto()));
		return entity;
	}

}
