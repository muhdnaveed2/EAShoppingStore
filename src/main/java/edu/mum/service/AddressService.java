package edu.mum.service;

import org.springframework.stereotype.Service;

import edu.mum.domain.Address;
import edu.mum.domain.Customer;

@Service
public interface AddressService {
	public void save(Address address);
	public Address getAddress(Customer customer);
}
