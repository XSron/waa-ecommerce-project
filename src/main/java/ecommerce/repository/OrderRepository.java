package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecommerce.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {
	@Query(value = "UPDATE orders SET order_status_id = 4 WHERE order_id = :orderId", nativeQuery = true)
	public void cancelOrder(@Param("orderId") Long id);
	@Query(value = "UPDATE orders SET order_status_id = :orderStatusId WHERE order_id = :orderId", nativeQuery = true)
	public void changeOrderStatus(@Param("orderId") Long orderId, @Param("orderStatusId") Integer orderStatusId);
	@Query(value = "SELECT * FROM orders AS O INNER JOIN order_detail AS OD ON O.order_id = OD.order_id WHERE OD.product_id = :productId", nativeQuery = true)
	public List
	<Orders> findOrderByProductId(@Param("productId") Long id);
}

