package com.olix.stock_system.domain.repository;

import com.olix.stock_system.domain.model.CustomExit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomExitRepository extends JpaRepository<CustomExit, Long> {

}
