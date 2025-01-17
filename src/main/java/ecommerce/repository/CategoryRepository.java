package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecommerce.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
