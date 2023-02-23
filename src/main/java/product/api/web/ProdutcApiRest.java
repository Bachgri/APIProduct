package product.api.web;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import product.api.entity.Product;
import product.api.repository.ProductRepository;


@RepositoryRestResource 
public class ProdutcApiRest {
	@Autowired
	ProductRepository productRepo;
	// get all
	@GetMapping(path = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> products(){
		return productRepo.findAll();
	}
	// Create
	@PostMapping("/products")
	public void add(@RequestAttribute("product") Product product) {
		productRepo.saveAndFlush(product);
	}
	
	// Read
	@GetMapping(path= "/products/{id}")
	public Product get(@PathVariable("id") Long id) {
		System.out.println(productRepo.findById(id).get());
		return productRepo.findById(id).get();
	}
	// Update
	@PutMapping("/products/{id}")
	public void put( @PathVariable("id") Long id , @RequestBody Product product) {
		Product p = productRepo.findById(id).get();
		p.setDesignation(product.getDesignation());
		p.setDiscription(product.getDiscription());
		p.setPrice(product.getPrice());
		p.setReference(product.getReference());
		p.setFournisseur(product.getFournisseur());
		productRepo.saveAndFlush(p);
	}
	// Delete
	@DeleteMapping(path = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Long id) {
		productRepo.delete(productRepo.findById(id).get());
	}
	
	
}
