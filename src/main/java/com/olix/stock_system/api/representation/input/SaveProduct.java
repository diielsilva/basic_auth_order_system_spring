package com.olix.stock_system.api.representation.input;

import javax.validation.constraints.NotBlank;

public class SaveProduct {
	@NotBlank(message = "Name cannot be empty, null or blank")
	private String name;

	public SaveProduct() {

	}

	public SaveProduct(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
