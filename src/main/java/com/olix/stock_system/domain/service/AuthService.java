package com.olix.stock_system.domain.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.olix.stock_system.domain.exception.ModelNotFoundException;
import com.olix.stock_system.domain.model.CustomUser;
import com.olix.stock_system.domain.repository.CustomUserRepository;

@Service
public class AuthService implements UserDetailsService {
	private CustomUserRepository repository;

	public AuthService(CustomUserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<CustomUser> userToAuth = this.repository.findByUsername(username);
		if (userToAuth.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		return userToAuth.get();
	}

	public CustomUser findByUsername(String username) {
		Optional<CustomUser> userToAuth = this.repository.findByUsername(username);
		if (userToAuth.isEmpty()) {
			throw new ModelNotFoundException("CustomUser");
		}
		return userToAuth.get();
	}

}
