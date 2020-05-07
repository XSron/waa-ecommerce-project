package ecommerce.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.OrderStatus;
import ecommerce.repository.OrderStatusRepository;
import ecommerce.service.OrderStatusService;

@Service
public class OrderStatusImpl implements OrderStatusService {
	@Autowired
	private OrderStatusRepository orderStatusRepo;
	
	@Override
	public void saveOrderStatus(OrderStatus orderStatus) {
		orderStatusRepo.save(orderStatus);
	}

	@Override
	public Iterable<OrderStatus> findAllOrderStatus() {
		return orderStatusRepo.findAll();
	}

	@Override
	public OrderStatus findOrderStatusById(Integer id) {
		return orderStatusRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteOrderStatusById(Integer id) {
		orderStatusRepo.deleteById(id);
	}

	@Override
	public List<OrderStatus> findAllOrderStatusExceptCancel() {
		return orderStatusRepo.findAllOrderStatusExceptCancel();
	}

}
