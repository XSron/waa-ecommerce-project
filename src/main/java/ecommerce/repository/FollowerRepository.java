package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecommerce.model.Follower;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Long> {

}
