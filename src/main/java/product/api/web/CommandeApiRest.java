package product.api.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import product.api.entity.Commande;
import product.api.repository.CommandeRepository;


@RepositoryRestResource
public class CommandeApiRest {
	
	@Autowired
	CommandeRepository commandeRepo;
	 
	@GetMapping(path = "/commandes", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Commande> clients(){
		return commandeRepo.findAll();
	}
	@PostMapping(path = "/commandes", produces = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Commande commande ) {
		commandeRepo.save(commande);
	}
	@GetMapping(path = "/commandes/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Commande client(@PathVariable("id") Long id ) {
		return commandeRepo.findById(id).get();
	}
	@DeleteMapping(path = "/commandes/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public void delete(@PathVariable("id") Long id ) {
		commandeRepo.delete(commandeRepo.findById(id).get());
	}
	@PutMapping(path = "/commandes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@PathVariable("id") Long id, @RequestBody Commande commande) {
		Commande c = commandeRepo.findById(id).get();
		c.setClient(commande.getClient());
		c.setProducts(commande.getProducts());
		c.setQuantite(commande.getQuantite());
		c.setStatus(commande.getStatus());
		commandeRepo.saveAndFlush(c);
	}
	
	
	
}	