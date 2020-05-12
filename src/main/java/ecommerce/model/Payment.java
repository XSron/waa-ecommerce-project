package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	@NotNull
	private String cardNumber;
	@NotNull
	private String nameOnCard;
	@NotNull
	private Integer expirationMonth;
	@NotNull
	private Integer expirationYear;
	public Payment() {
		cardNumber = "";
		nameOnCard = "";
		expirationMonth = 0;
		expirationYear = 0;
	}
	public Payment(String cardNumber, String nameOnCard, Integer expirationMonth, Integer expirationYear) {
		super();
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public Integer getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public Integer getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}
}
