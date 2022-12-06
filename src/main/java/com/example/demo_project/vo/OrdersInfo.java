package com.example.demo_project.vo;


public class OrdersInfo {
	private String customerId;

	private String name;

	private String productName;

	private int quantity;

	public OrdersInfo() {

	}

	public OrdersInfo(String customerId, String name, String productName, int quantity) {
		this.customerId = customerId;
		this.name = name;
		this.productName = productName;
		this.quantity = quantity;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
