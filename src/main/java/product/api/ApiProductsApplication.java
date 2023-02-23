package product.api;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import product.api.entity.Client;
import product.api.entity.Commande;
import product.api.entity.Fournisseur;
import product.api.entity.Product;
import product.api.repository.ClientRepository;
import product.api.repository.CommandeRepository;
import product.api.repository.FournisseurRepository;
import product.api.repository.ProductRepository;

@SpringBootApplication
public class ApiProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProductsApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository prodRepo, FournisseurRepository fr, CommandeRepository cr, ClientRepository clientRepo ) {
		return args->{
			Fournisseur f = new Fournisseur("fournisseur1", "Gournisseur1@gmail.com", "0622115470", "Rabat");
			f.setId(1L);
			fr.save(f);
			Product p =new Product();
			p.setId(1L);
			p.setDesignation("designationP1");
			p.setDiscription("Discription p1");
			p.setPrice(120);
			p.setFournisseur(f);
			prodRepo.save(p);
			Set<Product> products = new HashSet<>();
			products.add(p);
			Client client = new Client("oualid Client", "0622115470", "Salé");
			client.setId(1L);
			clientRepo.save(client);
			Commande c = new Commande(10, new Timestamp(2023-1900, 02, 22, 21, 22, 53, 0),"En cours" ,client ,products );
			c.setId(1L);
			cr.save(c);
		};
	}
		
									
}
