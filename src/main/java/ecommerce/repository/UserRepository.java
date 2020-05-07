package ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecommerce.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value = "SELECT * FROM user WHERE username = :username", nativeQuery = true)
	public User findByUsername(@Param("username") String username);
}
