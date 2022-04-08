package com.olix.stock_system.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olix.stock_system.api.helper.PasswordHelper;
import com.olix.stock_system.domain.exception.ModelNotFoundException;
import com.olix.stock_system.domain.exception.UnknowAuthorityException;
import com.olix.stock_system.domain.exception.UsernameInUseException;
import com.olix.stock_system.domain.model.CustomUser;
import com.olix.stock_system.domain.repository.CustomUserRepository;

@Service
public class CustomUserService {
	private CustomUserRepository customUserRepository;
	private PasswordHelper passwordHelper;

	public CustomUserService(CustomUserRepository customUserRepository, PasswordHelper passwordHelper) {
		this.customUserRepository = customUserRepository;
		this.passwordHelper = passwordHelper;
	}

	@Transactional
	public void save(CustomUser customUser) {
		if (!canUserAuthority(customUser.getRawAuthorities())) {
			throw new UnknowAuthorityException();
		} else if (!canUseUsername(customUser.getUsername())) {
			throw new UsernameInUseException();
		}
		customUser.setAuthorities(customUser.getRawAuthorities().toUpperCase());
		customUser.setPassword(this.passwordHelper.getEncoder().encode(customUser.getPassword()));
		this.customUserRepository.save(customUser);
	}

	public List<CustomUser> findAll() {
		return this.customUserRepository.findAll();
	}

	public CustomUser findById(Long id) {
		Optional<CustomUser> databaseUser = this.customUserRepository.findById(id);
		if (databaseUser.isEmpty()) {
			throw new ModelNotFoundException("CustomUser");
		}
		return databaseUser.get();
	}

	@Transactional
	public void deleteById(Long id) {
		Optional<CustomUser> databaseUser = this.customUserRepository.findById(id);
		if (databaseUser.isEmpty()) {
			throw new ModelNotFoundException("CustomUser");
		}
		this.customUserRepository.delete(databaseUser.get());
	}

	private Boolean canUserAuthority(String authority) {
		Boolean canUseAuthority = true;
		if (!authority.equals("ADMIN") && !authority.equals("USER")) {
			canUseAuthority = false;
		}
		return canUseAuthority;
	}

	private Boolean canUseUsername(String username) {
		Boolean canUseUsername = true;
		Optional<CustomUser> databaseUser = this.customUserRepository.findByUsername(username);
		if (databaseUser.isPresent()) {
			canUseUsername = false;
		}
		return canUseUsername;
	}
}
