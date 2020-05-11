package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	@Query(value = "SELECT * FROM Product P INNER JOIN Category C ON P.Category_ID = C.Category_ID WHERE P.USER_ID = :userId", nativeQuery = true)
	public List<Product> findProductByUserId(@Param("userId") Integer id);
	@Query(value = "SELECT CASE COUNT(*) WHEN 0 THEN FALSE ELSE TRUE END As Result FROM orders o INNER JOIN order_detail od ON o.order_id = od.order_id WHERE od.product_id = :productId AND o.order_by = :orderById", nativeQuery = true)
	public Boolean isBuyerBuyProductById(@Param("productId") Long productId, @Param("orderById") Integer orderById);
	@Query(value = "UPDATE product SET qty = qty - :qty WHERE product_id = :productId", nativeQuery = true)
	@Modifying
	public void updateQty(@Param("productId") Long productId,@Param("qty") Integer qty);
}
