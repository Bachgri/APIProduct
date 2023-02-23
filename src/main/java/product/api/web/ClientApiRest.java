package product.api.web;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import product.api.entity.Client;
import product.api.entity.Product; 
import product.api.repository.ClientRepository;


@RepositoryRestResource
public class ClientApiRest {

	@Autowired
	ClientRepository clientRepo;
	 
	@GetMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Client> clients(){
		return clientRepo.findAll();
	}
	@PostMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Client client ) {
		clientRepo.save(client);
	}
	@GetMapping(path = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Client client(@PathVariable("id") Long id ) {
		return clientRepo.findById(id).get();
	}
	@DeleteMapping(path = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public void delete(@PathVariable("id") Long id ) {
		clientRepo.delete(clientRepo.getById(id));
	}
	@PutMapping(path = "/clients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") Long id, @RequestBody Client client) {
		Client c = clientRepo.findById(id).get();
		c.setAddress(client.getAddress());
		c.setName(client.getName());
		c.setPhone(client.getPhone());
		clientRepo.saveAndFlush(c);
	}
}
