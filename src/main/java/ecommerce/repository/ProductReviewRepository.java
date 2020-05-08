package ecommerce.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ecommerce.model.ProductReview;

public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
	@Query(value = "UPDATE Product_Review SET Is_Approve = true WHERE Product_Review_Id = :productReviewId", nativeQuery = true)
	@Modifying
	public void approveProductReview(@Param("productReviewId") Long id);
}
