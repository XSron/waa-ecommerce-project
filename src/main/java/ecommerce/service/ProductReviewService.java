package ecommerce.service;

import org.springframework.data.repository.query.Param;

import ecommerce.model.ProductReview;

public interface ProductReviewService {
	public void review(ProductReview productReview);
	public Iterable<ProductReview> findAllProductReview();
	public ProductReview findProductReviewById(Long id);
	public void deleteProductReviewById(Long id);
	public void approveProductReview(@Param("productReviewId") Long id);
}
