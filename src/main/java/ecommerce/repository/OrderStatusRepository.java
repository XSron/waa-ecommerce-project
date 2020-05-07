package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import ecommerce.model.OrderStatus;

public interface OrderStatusRepository extends CrudRepository<OrderStatus, Integer> {

}
