package com.olix.stock_system.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olix.stock_system.api.representation.output.ShowUser;
import com.olix.stock_system.common.mapper.ModelMapper;
import com.olix.stock_system.domain.model.CustomUser;
import com.olix.stock_system.domain.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private AuthService authService;
	private ModelMapper modelMapper;

	public AuthController(AuthService authService, ModelMapper modelMapper) {
		this.authService = authService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<ShowUser> authenticate(@RequestHeader(value = "Authorization") String encodedHeader) {
		CustomUser customUser = this.authService.findByUsername(encodedHeader);
		ShowUser showUser = this.modelMapper.getCustomUserMapper().fromCustomUserToShowUser(customUser);
		return new ResponseEntity<ShowUser>(showUser, HttpStatus.OK);
	}
}
