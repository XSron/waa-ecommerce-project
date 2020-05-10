package ecommerce.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.OrderStatus;
import ecommerce.model.Orders;
import ecommerce.repository.OrderRepository;
import ecommerce.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public void saveOrder(Orders order) {
		order.setOrderReferenceNumber(orderRepo.generateOrdertNumber());
		orderRepo.save(order);
	}

	@Override
	public Iterable<Orders> findAllOrder() {
		return orderRepo.findAll();
	}

	@Override
	public Orders findOrderById(Long id) {
		return orderRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteOrderById(Long id) {
		orderRepo.deleteById(id);
	}

	@Override
	public void cancelOrder(Long id) {
		orderRepo.cancelOrder(id);
	}

	@Override
	public void changeShippingStatus(Long id, OrderStatus orderStatus) {
		orderRepo.changeOrderStatus(id, orderStatus.getOrderStatusId());
	}

	@Override
	public List<Orders> findOrderByProductId(Long id) {
		return orderRepo.findOrderByProductId(id);
	}

	@Override
	public List<Orders> findOrderBySellerId(Integer id) {
		return orderRepo.findOrderBySellerId(id);
	}

	@Override
	public List<Orders> findOrderByBuyerId(Integer id) {
		return orderRepo.findOrderByBuyerId(id);
	}

	@Override
	public double findTotalOrderAmountByOrderId(Long id) {
		return orderRepo.findTotalOrderAmountByOrderId(id);
	}
}
