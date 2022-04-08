package com.olix.stock_system.domain.exception;

public class UnknowAuthorityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public UnknowAuthorityException() {
		this.message = "Unknow authority received";
	}

	public String getMessage() {
		return message;
	}

}
