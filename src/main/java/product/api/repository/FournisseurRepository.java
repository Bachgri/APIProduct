package product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import product.api.entity.Fournisseur;
 

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{

}
