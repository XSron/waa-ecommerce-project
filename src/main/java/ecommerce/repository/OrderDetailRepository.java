package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ecommerce.model.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
	@Query(value = "SELECT * FROM order_detail WHERE order_id = :orderId", nativeQuery = true)
	public List<OrderDetail> findOrderDetailByOrderId(@Param("orderId") Long orderId);
}
