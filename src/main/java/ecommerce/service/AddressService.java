package ecommerce.service;

import ecommerce.model.Address;

public interface AddressService {
	public void saveAddress(Address address);
	public Iterable<Address> findAllAddress();
	public Address findAddressById(Long id);
	public void deleteAddressById(Long id);
}
