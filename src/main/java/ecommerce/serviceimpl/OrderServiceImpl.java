package ecommerce.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.OrderDetail;
import ecommerce.model.OrderStatus;
import ecommerce.model.Orders;
import ecommerce.repository.OrderRepository;
import ecommerce.service.OrderDetailService;
import ecommerce.service.OrderService;
import ecommerce.service.ProductService;
import ecommerce.service.UserService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private UserService userService;
	
	@Override
	public void saveOrder(Orders order) {
		order.setOrderReferenceNumber(orderRepo.generateOrdertNumber());
		//update product qty
		for(OrderDetail od: order.getOrderDetail())
			productService.updateQty(od.getProduct().getProductId(), od.getQty());
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
		//update qty
		List<OrderDetail> orderDetails = orderDetailService.findOrderDetailByOrderId(id);
		for(OrderDetail od: orderDetails)
			productService.updateQty(od.getProduct().getProductId(), (od.getQty() * -1));
		orderRepo.cancelOrder(id);
	}

	@Override
	public void changeShippingStatus(Long id, OrderStatus orderStatus) {
		//update point when the product already delivered 
		if(orderStatus.getOrderStatusId() == 4) {
			Orders order = findOrderById(id);
			double total = 0;
			int userId = order.getOrderBy().getUserId();
			for(OrderDetail od: order.getOrderDetail())
				total += od.getQty() * od.getProduct().getPrice();
			userService.updatePoint(userId, total * 0.10);
		}
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
