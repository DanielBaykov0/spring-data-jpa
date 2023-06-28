package baykov.daniel.springdatajpa.repositories;

import baykov.daniel.springdatajpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
