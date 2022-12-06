package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRes {

	private String name;
	private int price;
	private int quantity;
	private String message;
	private List<OrderRes> allList;

//	private  List<Menu> list;

	public OrderRes() {

	}
	
	public OrderRes(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public OrderRes(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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

	public List<OrderRes> getAllList() {
		return allList;
	}

	public void setAllList(List<OrderRes> allList) {
		this.allList = allList;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public List<Menu> getList() {
//		return list;
//	}
//
//	public void setList(List<Menu> list) {
//		this.list = list;
//	}

	


}