package ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private Integer qty;
	private Double price;
	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;
	@Transient
	private MultipartFile tmpImage;
	private String image;
	@OneToMany(mappedBy = "product")
	private List<ProductReview> productReview;
	public Product() {}
	public Product(String productName, Integer qty, Double price, Category category, User user, MultipartFile image) {
		super();
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.category = category;
		this.user = user;
		this.image = image.getOriginalFilename();
	}
	public Product(String productName, Integer qty, Double price, Category category, User user,
			String image) {
		super();
		this.productName = productName;
		this.qty = qty;
		this.price = price;
		this.category = category;
		this.user = user;
		this.image = image;
	}
	public Product(Long productId) {
		super();
		this.productId = productId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MultipartFile getTmpImage() {
		return tmpImage;
	}
	public void setTmpImage(MultipartFile tmpImage) {
		this.tmpImage = tmpImage;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public List<ProductReview> getProductReview() {
		return productReview;
	}
	public void setProductReview(List<ProductReview> productReview) {
		this.productReview = productReview;
	}
}
