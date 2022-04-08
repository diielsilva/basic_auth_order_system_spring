package com.olix.stock_system.domain.exception;

public class UsernameInUseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public UsernameInUseException() {
		this.message = "Username already in use";
	}

	public String getMessage() {
		return message;
	}

}
