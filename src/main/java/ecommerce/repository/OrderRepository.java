package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecommerce.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {
	@Query(value = "UPDATE orders SET order_status_id = 5 WHERE order_id = :orderId", nativeQuery = true)
	@Modifying
	public void cancelOrder(@Param("orderId") Long id);
	@Query(value = "UPDATE orders SET order_status_id = :orderStatusId WHERE order_id = :orderId", nativeQuery = true)
	@Modifying
	public void changeOrderStatus(@Param("orderId") Long orderId, @Param("orderStatusId") Integer orderStatusId);
	@Query(value = "SELECT * FROM orders AS O INNER JOIN order_detail AS OD ON O.order_id = OD.order_id WHERE OD.product_id = :productId", nativeQuery = true)
	public List<Orders> findOrderByProductId(@Param("productId") Long id);
	@Query(value = "SELECT * FROM Orders WHERE Order_ID IN(SELECT Order_ID FROM ORDER_DETAIL OD INNER JOIN Product P ON OD.Product_ID = P.Product_ID WHERE P.User_ID = :sellerId)", nativeQuery = true)
	public List<Orders> findOrderBySellerId(@Param("sellerId") Integer id);
	@Query(value = "SELECT * FROM Orders WHERE order_by = :buyerId", nativeQuery = true)
	public List<Orders> findOrderByBuyerId(@Param("buyerId") Integer id);
	@Query(value = "SELECT ISNULL(SUM(OD.Qty * P.Price),0) FROM ORDER_DETAIL OD INNER JOIN PRODUCT P ON OD.Product_ID = P.Product_ID WHERE Order_ID = :orderId", nativeQuery = true)
	public double findTotalOrderAmountByOrderId(@Param("orderId") Long id);
	@Query(value = "SELECT CONCAT('REF#-', IFNULL(MAX(RIGHT(order_reference_number, LENGTH(order_reference_number) - 5)), 0) + 1) FROM orders", nativeQuery = true)
	public String generateOrdertNumber();
}

