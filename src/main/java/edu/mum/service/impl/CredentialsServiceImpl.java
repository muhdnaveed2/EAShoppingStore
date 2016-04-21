package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Credentials;
import edu.mum.repository.CredentialsRepository;
import edu.mum.service.CredentialsService;

@Service
@Transactional 
public class CredentialsServiceImpl implements CredentialsService {
	
 	@Autowired
	private CredentialsRepository credentialsRepository;

//  	@PreAuthorize("hasRole('ROLE_DOCTOR')")
  	public void save(Credentials credentials) {

  		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
  		String encodedPassword = passwordEncoder.encode(credentials.getPassword());
  		credentials.getAuthority().setUsername(credentials.getUsername());
  		credentials.setVerifyPassword(credentials.getPassword());
  		credentials.setPassword(encodedPassword);
  		
//  		credentialsRepository.save(credentials);
	}
	public List<Credentials> findAll() {
		return (List<Credentials>)credentialsRepository.findAll();
	}

 
}
