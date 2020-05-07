package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ecommerce.model.OrderStatus;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Integer> {
	@Query(value = "SELECT * FROM Order_Status WHERE Order_Status_Id <> 5", nativeQuery = true)
	public List<OrderStatus> findAllOrderStatusExceptCancel();
}
