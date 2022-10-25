package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;

public class MenuRes {
	private List<Menu> menuList;

//	private int totalPrice;

	public MenuRes() {

	}
	
	public MenuRes(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
//	public MenuRes(List<Menu> menuList, int totalPrice) {
//		this.menuList = menuList;
//		this.totalPrice = totalPrice;
//	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

//	public int getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setTotalPrice(int totalPrice) {
//		this.totalPrice = totalPrice;
//	}

}
