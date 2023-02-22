package product.api.web;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import product.api.entity.Client;
import product.api.entity.Fournisseur;
import product.api.repository.FournisseurRepository;

@Component
@Path("/FournisseurApi")
public class FournisseurApiRest {
	@Autowired
	FournisseurRepository fournRepo;
	
	
	@GetMapping(path = "/fournisseurs", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Fournisseur> clients() {
		return fournRepo.findAll();
	}
	@GetMapping(path = "/fournisseur/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Fournisseur client(@PathParam("id") Long id ) {
		return fournRepo.getById(id);
	}
	@PostMapping(path = "/fournisseur/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Fournisseur save(@RequestBody Fournisseur fournisseur ) {
		return fournRepo.save(fournisseur);
	}
	
	
	
	
}
