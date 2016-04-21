package edu.mum.service;

import edu.mum.domain.Authority;

public interface WelcomeService {

	public Authority getRole(String username);
}
