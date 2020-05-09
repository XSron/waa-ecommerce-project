package ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import ecommerce.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
