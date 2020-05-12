package ecommerce.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Follower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long followerId;
	@OneToOne
	@JoinColumn(name = "seller_id",  referencedColumnName = "userId")
	@Valid
	private User seller;
	@OneToOne
	@JoinColumn(name = "buyer_id", referencedColumnName = "userId")
	@Valid
	private User buyer;
	@NotNull
	private LocalDateTime followDate;
	public Follower() {}
	public Follower(User seller, User buyer, LocalDateTime followDate) {
		super();
		this.seller = seller;
		this.buyer = buyer;
		this.followDate = followDate;
	}
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public LocalDateTime getFollowDate() {
		return followDate;
	}
	public void setFollowDate(LocalDateTime followDate) {
		this.followDate = followDate;
	}
}
