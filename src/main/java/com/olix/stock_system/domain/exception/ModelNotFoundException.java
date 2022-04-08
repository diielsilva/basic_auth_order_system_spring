package com.olix.stock_system.domain.exception;

public class ModelNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public ModelNotFoundException(String modelName) {
		this.message = modelName + " not found";
	}

	public String getMessage() {
		return this.message;
	}

}
