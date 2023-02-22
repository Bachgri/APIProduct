package product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import product.api.entity.Client;
 

public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
