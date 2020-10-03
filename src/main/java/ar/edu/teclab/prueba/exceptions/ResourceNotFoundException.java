package ar.edu.teclab.prueba.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() { }

    public ResourceNotFoundException(String entity, Long id) {
        super(entity + " id " + id + " no se ecuentra");
    }
    public ResourceNotFoundException(String string) {
        super(string);
    }
   
}