package com.olix.stock_system.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olix.stock_system.api.representation.input.SaveUser;
import com.olix.stock_system.api.representation.output.ShowUser;
import com.olix.stock_system.common.mapper.ModelMapper;
import com.olix.stock_system.domain.model.CustomUser;
import com.olix.stock_system.domain.service.CustomUserService;

@RestController
@RequestMapping("/users")
public class CustomUserController {
	private CustomUserService customUserService;
	private ModelMapper modelMapper;

	public CustomUserController(CustomUserService customUserService, ModelMapper modelMapper) {
		this.customUserService = customUserService;
		this.modelMapper = modelMapper;
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid SaveUser saveUser) {
		CustomUser customUser = this.modelMapper.getCustomUserMapper().fromSaveUserToCustomUser(saveUser);
		this.customUserService.save(customUser);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ShowUser>> findAll() {
		List<CustomUser> customUserList = this.customUserService.findAll();
		List<ShowUser> showUserList = this.modelMapper.getCustomUserMapper()
				.fromCustomUserListToShowUserList(customUserList);
		return new ResponseEntity<List<ShowUser>>(showUserList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShowUser> findById(@PathVariable Long id) {
		CustomUser customUser = this.customUserService.findById(id);
		ShowUser showUser = this.modelMapper.getCustomUserMapper().fromCustomUserToShowUser(customUser);
		return new ResponseEntity<ShowUser>(showUser, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		this.customUserService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
