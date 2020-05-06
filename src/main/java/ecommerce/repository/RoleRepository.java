package ecommerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecommerce.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	@Query(value = "SELECT * FROM role where role_id <> 1", nativeQuery = true)
	public Iterable<Role> findAllRoleExceptAdmin();
}
