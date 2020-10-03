package ar.edu.teclab.prueba.controller;

import java.util.HashMap;
import java.util.List;

import ar.edu.teclab.prueba.exceptions.ConflictException;
import ar.edu.teclab.prueba.service.TicketService;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.teclab.prueba.dto.Ejemplo;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class PruebaController {

	private static final Log LOG = LogFactory.getLog(PruebaController.class);

	@Autowired
	protected TicketService ticketService;


	@GetMapping("/ejemplo")
	public ResponseEntity<Ejemplo> getMessageStatus(@RequestParam(value ="nombre") String nombre) {
		try {
			Ejemplo ejemplo = new Ejemplo();
			ejemplo.setNombre(nombre);
			return ResponseEntity.ok(ejemplo);
		}catch (Exception e){
			LOG.error("Error", e);
		}
		return null;
	}

	//listar tickets
	@GetMapping("/comments/ticket/{ticketId}")
	public ResponseEntity<List<Object>> getCommentsByTicketId(@PathVariable Integer ticketId) {

		if(ticketId!=null){
		try {
			List<Object> commentByTicket = ticketService.getCommentByTicket(ticketId);
			return ResponseEntity.ok(commentByTicket);
		} catch (Exception e) {
			LOG.error(e);
		}
		}else{
			throw new ConflictException("Debe ingresar un ticket valido");
		}
		return null;
	}

	//insertar comentario en ticket
	@PutMapping("/insert/comment/ticket/{ticketId}")
	public ResponseEntity<HashMap<String, String>> insertComment(@PathVariable Integer ticketId,
																 @RequestBody JsonNode ticketComment) {


			HashMap<String, String> response= new HashMap<>();
			if(ticketId!=null){

				try {
					ticketService.insertComment(ticketId, ticketComment);
					response.put("Result", "OK");
					return ResponseEntity.ok(response);
				} catch (Exception e) {
					LOG.error(e);
				}

			}else{
				throw new ConflictException("Debe ingresar un ticket valido");
			}

		return null;
	}
	
}


