package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.domain.Address;
import edu.mum.domain.Customer;
import edu.mum.repository.AddressRepository;
import edu.mum.service.AddressService;

@Service
public class AddressImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void save(Address address) {
		// TODO Auto-generated method stub
		addressRepository.save(address);
	}

	@Override
	public Address getAddress(Customer customer) {
		return addressRepository.findOne(customer.getId());

	}

}
