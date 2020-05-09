package ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Payment;
import ecommerce.repository.PaymentRepository;
import ecommerce.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Override
	public void savePayment(Payment payment) {
		paymentRepo.save(payment);
	}

	@Override
	public Iterable<Payment> findAllPayment() {
		return paymentRepo.findAll();
	}

	@Override
	public Payment findPaymentById(Long id) {
		return paymentRepo.findById(id).orElse(null);
	}

	@Override
	public void deletePaymentById(Long id) {
		paymentRepo.deleteById(id);
	}

}
