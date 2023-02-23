package product.api.web;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Path;

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
import product.api.entity.Fournisseur;
import product.api.repository.FournisseurRepository;


@RepositoryRestResource
public class FournisseurApiRest {
	@Autowired
	FournisseurRepository fournRepo;
	
	
	@GetMapping(path = "/fournisseurs", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Fournisseur> clients() {
		return fournRepo.findAll();
	}
	@GetMapping(path = "/fournisseurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Fournisseur client(@PathVariable("id") Long id ) {
		return fournRepo.findById(id).get();
	}
	@PostMapping(path = "/fournisseurs", produces = MediaType.APPLICATION_JSON_VALUE )
	public Fournisseur save(@RequestBody Fournisseur fournisseur ) {
		return fournRepo.save(fournisseur);
	}
	@PutMapping(path = "/fournisseurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public void edit(@PathVariable("id")  Long id ,@RequestBody Fournisseur fournisseur ) { 
		Fournisseur f = fournRepo.findById(id).get();
		f.setEmail(fournisseur.getEmail());
		f.setName(fournisseur.getName());
		f.setPhone(fournisseur.getPhone());
		f.setVille(fournisseur.getVille());
		fournRepo.save(f);
	}
	@DeleteMapping(path = "/fournisseurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public void delete(@PathVariable("id") Long id ) {
		fournRepo.delete(fournRepo.findById(id).get());
	}
	
	
	
	
}
