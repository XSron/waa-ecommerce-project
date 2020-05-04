package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
