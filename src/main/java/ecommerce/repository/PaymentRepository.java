package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import ecommerce.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
