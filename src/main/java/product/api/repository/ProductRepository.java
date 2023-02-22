package product.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import product.api.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
		
}
