package ecommerce.service;

import java.util.List;
import ecommerce.model.OrderStatus;
import ecommerce.model.Orders;

public interface OrderService {
	public void saveOrder(Orders order);
	public List<Orders> findAllOrder();
	public Orders findOrderById(Long id);
	public void deleteOrderById(Long id);
	public void cancelOrder(Long id);
	public void changeShippingStatus(Long id, OrderStatus orderStatus);
}
