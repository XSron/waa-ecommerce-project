package ecommerce.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.ProductReview;
import ecommerce.repository.ProductReviewRepository;
import ecommerce.service.ProductReviewService;

@Service
@Transactional
public class ProductReviewServiceImpl implements ProductReviewService {
	@Autowired
	private ProductReviewRepository productReviewRepo;
	
	@Override
	public void review(ProductReview productReview) {
		productReviewRepo.save(productReview);
	}

	@Override
	public Iterable<ProductReview> findAllProductReview() {
		return productReviewRepo.findAll();
	}

	@Override
	public ProductReview findProductReviewById(Long id) {
		return productReviewRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteProductReviewById(Long id) {
		productReviewRepo.deleteById(id);
	}

	@Override
	public void approveProductReview(Long id) {
		productReviewRepo.approveProductReview(id);
	}

}
