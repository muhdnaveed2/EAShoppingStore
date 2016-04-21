package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Authority;
import edu.mum.repository.WelcomeRepository;
import edu.mum.service.WelcomeService;

@Service
@Transactional
public class WelcomeServiceImpl implements WelcomeService {

	@Autowired
	private WelcomeRepository welcomeRepository;
	
	@Override
	public Authority getRole(String username)
	{
		return welcomeRepository.getByUsername(username);
	}

}
