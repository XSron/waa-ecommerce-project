package ecommerce.service;

import ecommerce.model.Payment;

public interface PaymentService {
	public void savePayment(Payment payment);
	public Iterable<Payment> findAllPayment();
	public Payment findPaymentById(Long id);
	public void deletePaymentById(Long id);
}
