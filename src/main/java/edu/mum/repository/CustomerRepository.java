package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>
{
	public Customer findByCredentialsUsername(String username);

}
