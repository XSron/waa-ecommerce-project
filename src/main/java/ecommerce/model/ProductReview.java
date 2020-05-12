package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
public class ProductReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productReviewId;
	@OneToOne
	@JoinColumn(name = "product_id")
	@Valid
	private Product product;
	@NotBlank
	private String comment;
	@OneToOne
	@JoinColumn(name = "reviewed_by")
	@Valid
	private User reviewBy;
	private boolean isApprove;
	public ProductReview() {}
	public ProductReview(Product product, String comment, User reviewBy) {
		super();
		this.product = product;
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
