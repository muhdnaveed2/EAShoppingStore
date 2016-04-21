package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
