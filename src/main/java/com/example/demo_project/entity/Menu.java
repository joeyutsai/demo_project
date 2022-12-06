package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private int price;
	
//	private int quantity;

	public Menu() {

	}
	
	public Menu(String name) {
		this.name = name;
	}

	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
//	public Menu(String name, int price, int quantity) {
//		this.name = name;
//		this.price = price;
//		this.quantity = quantity;
//	}

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

//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

}
