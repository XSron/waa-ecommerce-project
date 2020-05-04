package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecommerce.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
