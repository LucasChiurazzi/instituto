package ar.edu.teclab.prueba.converter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericConverter<A, B> {
	
public abstract A toDto(B entity);
	
	public List<A> toDtoList(List<B> entities) {
		List<A> result = new ArrayList<>();
		for (B b : entities) {
			result.add(toDto(b));
		}
		return result;
	}

	
	public abstract B toEntity(A dto) throws Exception;

	public List<B> toEntityList(List<A> entities) throws Exception {
		List<B> result = new ArrayList<>();
		for (A a : entities) {
			result.add(toEntity(a));
		}
		return result;
	}
}
