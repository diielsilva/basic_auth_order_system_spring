package com.olix.stock_system.domain.exception;

public class ProductNameInUseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public ProductNameInUseException() {
		this.message = "Product name already in use";
	}

	public String getMessage() {
		return message;
	}

}
