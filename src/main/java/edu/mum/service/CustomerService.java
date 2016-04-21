package edu.mum.service;

import edu.mum.domain.Customer;

public interface CustomerService {

	public void save(Customer customer);
	
	public Customer getCustomer(String username);
	
	public void saveOrderInfo(Customer customer);
}
