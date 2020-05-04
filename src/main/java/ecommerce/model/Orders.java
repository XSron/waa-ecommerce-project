package ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private String orderReferenceNumber;
	private LocalDateTime orderDate;
	@OneToOne
	@JoinColumn(name = "order_by", referencedColumnName = "userId")
	private User orderBy;
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetail;
	@OneToOne
	@JoinColumn(name = "order_status_id", referencedColumnName = "orderStatusId")
	private OrderStatus orderStatus;
	public Orders() {}
	public Orders(String orderReferenceNumber, LocalDateTime orderDate, List<OrderDetail> orderDetail, User orderBy, OrderStatus orderStatus) {
		super();
		this.orderReferenceNumber = orderReferenceNumber;
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
		this.orderBy = orderBy;
		this.orderStatus = orderStatus;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderReferenceNumber() {
		return orderReferenceNumber;
	}
	public void setOrderReferenceNumber(String orderReferenceNumber) {
		this.orderReferenceNumber = orderReferenceNumber;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public User getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(User orderBy) {
		this.orderBy = orderBy;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
}
