package ecommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@NotBlank
	private String orderReferenceNumber;
	@NotNull
	private LocalDateTime orderDate;
	@OneToOne
	@JoinColumn(name = "order_by", referencedColumnName = "userId")
	@Valid
	private User orderBy;
	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	@Valid
	private List<@Valid OrderDetail> orderDetail;
	@OneToOne
	@JoinColumn(name = "order_status_id", referencedColumnName = "orderStatusId")
	@Valid
	private OrderStatus orderStatus;
	public Orders() {}
	public Orders(LocalDateTime orderDate, List<OrderDetail> orderDetail, User orderBy) {
		super();
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
		this.orderBy = orderBy;
		this.orderStatus = new OrderStatus(1); //ORDERED
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
