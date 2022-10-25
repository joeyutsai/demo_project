package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Menu;

public class OrderRes {
	private String name;
	private int price;
	private int quantity;
	private String message;
	
	// *
	private  List<Menu> list;
	// *
	


	public OrderRes() {

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}

	


}