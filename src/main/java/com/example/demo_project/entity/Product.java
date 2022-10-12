package com.example.demo_project.entity;

public class Product {
	String name;
	int price;
	int storage;

	public Product(){
		
	}
	
	public Product(String name, int storage) {
		this.name = name;
		this.storage = storage;
	}
	
	public Product(String name, int price, int storage) {
		this.name = name;
		this.price = price;
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

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
	
}
