package ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.OrderDetail;
import ecommerce.repository.OrderDetailRepository;
import ecommerce.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepo;
	
	@Override
	public List<OrderDetail> findOrderDetailByOrderId(Long orderId) {
		return orderDetailRepo.findOrderDetailByOrderId(orderId);
	}

}
