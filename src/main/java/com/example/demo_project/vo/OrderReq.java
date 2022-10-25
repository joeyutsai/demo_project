package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderReq {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private int price;
	
	@JsonProperty("quantity")
	private int quantity;

	public OrderReq() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
