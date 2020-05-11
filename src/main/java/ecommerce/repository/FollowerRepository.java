package ecommerce.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecommerce.model.Follower;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Long> {
	@Query(value = "SELECT * FROM follower where seller_id = :sellerId", nativeQuery = true)
	public Iterable<Follower> getAllFollowersBySellerId(@Param("sellerId") Long id);
	@Query(value = "SELECT COUNT(*) FROM follower where seller_id = :sellerId AND buyer_id = :buyerId", nativeQuery = true)
	public Integer isFollow(@Param("sellerId") Integer sellerId,@Param("buyerId") Integer buyerId);
	@Query(value = "SELECT COUNT(*) FROM follower WHERE seller_id = :sellerId", nativeQuery = true)
	public Integer countFollowerBySellerId(@Param("sellerId") Integer id);
	@Query(value = "DELETE FROM follower where seller_id=:sellerId AND buyer_id=:buyerId", nativeQuery = true)
	@Modifying
	public void unfollow(@Param("sellerId") Integer sellerId, @Param("buyerId") Integer buyerId);
}
