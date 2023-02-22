package product.api.web;

import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import product.api.entity.Product;
import product.api.repository.ProductRepository;

@Path("/ProductsApi")
public class ProdutcApiRest {
	@Autowired
	ProductRepository productRepo;
	// get all
	@GetMapping(path = "/Products", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> products(){
		return productRepo.findAll();
	}
	// Create
	@PostMapping("/product")
	public void add(@RequestAttribute("product") Product product) {
		productRepo.saveAndFlush(product);
	}
	// Read
	@GetMapping(path= "/product/{id}")
	public Product get(@PathVariable("id") Long id) {
		return productRepo.getById(id);
	}
	// Update
	@PutMapping("/product")
	public void put(@RequestAttribute("product") Product product) {
		productRepo.saveAndFlush(product);
	}
	// Delete
	@DeleteMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Long id) {
		productRepo.delete(productRepo.getById(id));
	}
	
	
}
