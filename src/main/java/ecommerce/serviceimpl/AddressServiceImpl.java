package ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Address;
import ecommerce.repository.AddressRepository;
import ecommerce.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepo;
	
	@Override
	public void saveAddress(Address address) {
		addressRepo.save(address);
	}

	@Override
	public Iterable<Address> findAllAddress() {
		return addressRepo.findAll();
	}

	@Override
	public Address findAddressById(Long id) {
		return addressRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteAddressById(Long id) {
		addressRepo.deleteById(id);
	}

}
