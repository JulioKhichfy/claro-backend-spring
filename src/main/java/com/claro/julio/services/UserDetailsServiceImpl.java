package com.claro.julio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.claro.julio.domain.UserSystem;
import com.claro.julio.repositories.UserSystemRepository;
import com.claro.julio.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserSystemRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserSystem us = repo.findByEmail(email);
		if (us == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(us.getId(), us.getSenha(), us.getPerfis(),us.getEmail());
	}
}
