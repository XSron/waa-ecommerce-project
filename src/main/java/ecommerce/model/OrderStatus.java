package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * 1. SHIPPED
 * 2. ON-THE-WAY
 * 3. DELIVERED
 * 4. CANCELLED
 */

@Entity
public class OrderStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderStatusId;
	private String orderStatusName;
	public OrderStatus(String orderStatusName) {
		super();
		this.orderStatusName = orderStatusName;
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