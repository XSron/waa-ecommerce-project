package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProductReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productReviewId;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private Double rate;
	private String comment;
	@OneToOne
	@JoinColumn(name = "reviewed_by")
	private User reviewBy;
	private boolean isApprove;
	public ProductReview() {}
	public ProductReview(Product product, Double rate, String comment, User reviewBy) {
		super();
		this.product = product;
		this.rate = rate;
		this.comment = comment;
		this.reviewBy = reviewBy;
	}
	public Long getProductReviewId() {
		return productReviewId;
	}
	public void setProductReviewId(Long productReviewId) {
		this.productReviewId = productReviewId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getReviewBy() {
		return reviewBy;
	}
	public void setReviewBy(User reviewBy) {
		this.reviewBy = reviewBy;
	}
	public boolean getIsApprove() {
		return isApprove;
	}
	public void setApprove(boolean isApprove) {
		this.isApprove = isApprove;
	}
}
