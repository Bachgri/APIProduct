package product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import product.api.entity.Commande;
 

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
