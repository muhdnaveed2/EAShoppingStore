package edu.mum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.mum.domain.Authority;
import edu.mum.domain.Customer;

public interface WelcomeRepository  extends CrudRepository <Customer, Long>  {
	
	@Query("SELECT a FROM Authority a WHERE a.username=:username")
	public Authority getByUsername(@Param("username") String username);

}