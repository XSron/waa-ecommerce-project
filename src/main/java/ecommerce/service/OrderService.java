package ecommerce.service;

import ecommerce.model.OrderStatus;
import ecommerce.model.Orders;

public interface OrderService {
	public void saveOrder(Orders order);
	public Iterable<Orders> findAllOrder();
	public Orders findOrderById(Long id);
	public void deleteOrderById(Long id);
	public void cancelOrder(Long id);
	public void changeShippingStatus(Long id, OrderStatus orderStatus);
}
