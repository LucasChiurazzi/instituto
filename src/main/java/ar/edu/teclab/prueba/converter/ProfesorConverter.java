package ar.edu.teclab.prueba.converter;

import ar.edu.teclab.prueba.dto.CarreraDto;
import ar.edu.teclab.prueba.dto.ProfesorDto;
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.entity.Profesor;
import org.springframework.stereotype.Service;

@Service
public class ProfesorConverter extends GenericConverter<ProfesorDto, Profesor> {

	@Override
	public ProfesorDto toDto(Profesor entity) {
		ProfesorDto dto= new ProfesorDto();
		dto.setApellido(entity.getApellido());
		dto.setDni(entity.getDni());
		dto.setDomicilio(entity.getDomicilio());
		dto.setFechaNac(entity.getFechaNac());
		dto.setNombre(entity.getNombre());
		dto.setSexo(entity.getSexo());
		dto.setTelefono(entity.getTelefono());
		dto.setId(entity.getId());
		dto.setStatus(entity.getStatus());
		return dto;
	}

	@Override
	public Profesor toEntity(ProfesorDto dto) throws Exception {
		Profesor entity= new Profesor();
		entity.setApellido(dto.getApellido());
		entity.setDni(dto.getDni());
		entity.setDomicilio(dto.getDomicilio());
		entity.setFechaNac(dto.getFechaNac());
		entity.setNombre(dto.getNombre());
		entity.setSexo(dto.getSexo());
		entity.setTelefono(dto.getTelefono());
		entity.setStatus(dto.getStatus());
		return entity;
	}
}
