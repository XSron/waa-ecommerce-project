package ecommerce.service;

import java.util.List;

import ecommerce.model.OrderStatus;

public interface OrderStatusService {
	public void saveOrderStatus(OrderStatus orderStatus);
	public Iterable<OrderStatus> findAllOrderStatus();
	public List<OrderStatus> findAllOrderStatusExceptCancel();
	public OrderStatus findOrderStatusById(Integer id);
	public void deleteOrderStatusById(Integer id);
}
