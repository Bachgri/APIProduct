package product.api.web;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import product.api.entity.Client;
import product.api.entity.TestEntity;
import product.api.repository.ClientRepository;

@Component
@Path("/ClientApi")
public class ClientApiRest {

	@Autowired
	ClientRepository clientRepo;
	 
	@GetMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Client> clients(){
		return clientRepo.findAll();
	}
	@PostMapping(path = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Client client ) {
		clientRepo.save(client);
	}
	@GetMapping(path = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Client client(@PathParam("id") Long id ) {
		return clientRepo.getById(id);
	}
	@DeleteMapping(path = "/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public void delete(@PathParam("id") Long id ) {
		clientRepo.delete(clientRepo.getById(id));
	}
}
