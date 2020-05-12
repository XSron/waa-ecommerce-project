package ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String zipCode;
	@NotNull
	private String fullAddress;
	public Address() {
		city = "";
		state = "";
		zipCode = "";
		fullAddress = "";
	}
	public Address(String city, String state, String zipCode, String fullAddress) {
		super();
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.fullAddress = fullAddress;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
}
