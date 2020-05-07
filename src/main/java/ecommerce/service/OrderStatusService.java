package ecommerce.service;

import ecommerce.model.OrderStatus;

public interface OrderStatusService {
	public void saveOrderStatus(OrderStatus orderStatus);
	public Iterable<OrderStatus> findAllOrderStatus();
	public OrderStatus findOrderStatusById(Integer id);
	public void deleteOrderStatusById(Integer id);
}
