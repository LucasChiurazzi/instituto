package ar.edu.teclab.prueba.service;

import ar.edu.teclab.prueba.Config.ConstantConfig;
import ar.edu.teclab.prueba.exceptions.ConflictException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

@Service
public class TicketService {


    private static final Log LOG = LogFactory.getLog(PruebaService.class);


    public List<Object> getCommentByTicket(Integer ticketId){
        List<Object> response= new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        //set uri
        String uri= ConstantConfig.TICKET_BASE_URL+"/api/v2/tickets/"+ticketId+"/comments.json";
        //set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + getBase64Authorization());

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
            if(!responseEntity.getStatusCode().equals(HttpStatus.OK)){
                throw new ConflictException("problema");
            }
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseEntity.getBody());
            //control si existe el indice comments
            JsonNode comments = root.get("comments");
            response = Collections.singletonList(comments);
        }catch (Exception e){
            LOG.error("Error", e);
        }
        return response;
    }

    public HttpStatus insertComment(Integer ticketId, JsonNode ticketComment) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String uri= ConstantConfig.TICKET_BASE_URL+"/api/v2/tickets/"+ticketId+".json";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic "+ getBase64Authorization());
        HttpEntity<JsonNode> requestUpdate = new HttpEntity<>(ticketComment, headers);
        ResponseEntity<Void> exchange = restTemplate.exchange(uri, HttpMethod.PUT, requestUpdate, Void.class);
        HttpStatus statusCode = exchange.getStatusCode();
        return statusCode;

    }

    private String getBase64Authorization(){
        String user= ConstantConfig.TICKET_USER;
        String pass= ConstantConfig.TICKET_PASS;
        String toBase64 = user+":"+pass;
        return Base64.getEncoder().encodeToString(toBase64.getBytes());
    }


}
