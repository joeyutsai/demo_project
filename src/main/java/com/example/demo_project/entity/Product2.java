package com.example.demo_project.entity;

import javax.swing.Spring;

public class Product2 {
	String name;
	int price;
	int quantity;
	int storage;

	public Product2() {

	}
	
	public Product2(String name, int price, int quantity, int storage) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.storage = storage;
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

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	
}
