package com.olix.stock_system.api.helper;

public class ResponseHelper {
	private String message;

	public ResponseHelper(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
