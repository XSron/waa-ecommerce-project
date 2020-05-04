package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ecommerce.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {

}
