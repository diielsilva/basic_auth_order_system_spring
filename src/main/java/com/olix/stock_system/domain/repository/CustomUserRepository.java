package com.olix.stock_system.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olix.stock_system.domain.model.CustomUser;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
	Optional<CustomUser> findByUsername(String username);
}
