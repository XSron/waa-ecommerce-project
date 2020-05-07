package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * 1. ORDERED
 * 2. SHIPPED
 * 3. ON-THE-WAY
 * 4. DELIVERED
 * 5. CANCELLED
 */

@Entity
public class OrderStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderStatusId;
	private String orderStatusName;
	public OrderStatus() {}
	public OrderStatus(String orderStatusName) {
		super();
		this.orderStatusName = orderStatusName;
	}
	public OrderStatus(Integer orderStatusId) {
		super();
		this.orderStatusId = orderStatusId;
	}
	public Integer getOrderStatusId() {
		return orderStatusId;
	}
	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}
	public String getOrderStatusName() {
		return orderStatusName;
	}
	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
}
