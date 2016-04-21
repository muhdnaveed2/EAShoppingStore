package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.domain.Customer;
import edu.mum.repository.CustomerRepository;
import edu.mum.service.CredentialsService;
import edu.mum.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CredentialsService credentialsService;
	
	@Override
	public void save(Customer customer)
	{
		credentialsService.save(customer.getCredentials());
		customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(String username)
	{
		return customerRepository.findByCredentialsUsername(username);
	}

	@Override
	public void saveOrderInfo(Customer customer)
	{
		customerRepository.save(customer);	
	}
	
	
}
