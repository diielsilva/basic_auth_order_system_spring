package com.olix.stock_system.api.representation.input;

import javax.validation.constraints.NotBlank;

public class SaveUser {
	@NotBlank(message = "Name cannot be empty, null or blank")
	private String name;
	@NotBlank(message = "Username cannot be empty, null or blank")
	private String username;
	@NotBlank(message = "Password cannot be empty, null or blank")
	private String password;
	@NotBlank(message = "Authorities cannot be empty, null or blank")
	private String authorities;

	public SaveUser() {

	}

	public SaveUser(String name, String username, String password, String authorities) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

}
