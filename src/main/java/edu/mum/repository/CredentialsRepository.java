package edu.mum.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Credentials;


	@Repository
	public interface CredentialsRepository extends  CrudRepository<Credentials, String> 
	{
  	}

