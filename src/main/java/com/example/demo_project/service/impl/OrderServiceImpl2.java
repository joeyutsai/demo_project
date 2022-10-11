package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService2;

@Service
public class OrderServiceImpl2 implements OrderService2 {
	private Map<String, Integer> listMenu = new HashMap<String, Integer>();
	int totalPrice;

	@Override
	public void setMenuNamePrice(Menu menu) {
		listMenu.put(menu.getName(), menu.getPrice());
		System.out.println(menu.getName() + " PRICE: " + menu.getPrice());
	}

	@Override
	public void orderMenu(String menu, int quantity) {
		totalPrice += (listMenu.get(menu) * quantity);
		System.out.println(menu + " Quantity: " + quantity + " Price: " + (listMenu.get(menu) * quantity));
	}

	@Override
	public void getAllInfo() {
		if (totalPrice > 500) {
			totalPrice = (int) (totalPrice * (0.9));
			System.out.println("Discount: 10% OFF !!!");
		}
		System.out.println("All the menu price: " + totalPrice);
	}

}
