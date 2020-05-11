package ecommerce.service;

import java.util.List;

import ecommerce.model.OrderDetail;

public interface OrderDetailService {
	public List<OrderDetail> findOrderDetailByOrderId(Long orderId);
}
