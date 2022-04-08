package com.olix.stock_system.api.representation.output;

public class ShowProduct {
	private Long id;
	private String name;
	private Long amount;

	public ShowProduct() {

	}

	public ShowProduct(Long id, String name, Long amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
