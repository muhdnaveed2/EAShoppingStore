package edu.mum.service;

import java.util.List;

import edu.mum.domain.Credentials;

 
public interface CredentialsService {

	public void save(Credentials credentials);
	public List<Credentials> findAll();
 }
