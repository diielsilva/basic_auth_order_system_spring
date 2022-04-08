package com.olix.stock_system.api.representation.output;

public class ShowUser {
	private Long id;
	private String name;
	private String username;
	private String authorities;

	public ShowUser(Long id, String name, String username, String authorities) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

}
