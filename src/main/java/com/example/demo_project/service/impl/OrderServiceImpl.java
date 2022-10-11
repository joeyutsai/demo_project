package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	private Map<String, Integer> listMenu = new HashMap<String, Integer>();
	int totalPrice;

	@Override
	public void setMenuNamePrice(String nameMenu, int priceMenu) {
		listMenu.put(nameMenu, priceMenu);
		System.out.println(nameMenu + " PRICE: " + priceMenu); 
	}

	@Override
	public void orderMenu(String menu, int quantity) {
		totalPrice += (listMenu.get(menu) * quantity);
		System.out.println(menu + " Quantity: " + quantity + " Price: " + (listMenu.get(menu) * quantity));
	}

	@Override
	public void getAllPrice() {
		if (totalPrice > 500) {
			totalPrice = (int) (totalPrice * (0.9));
			System.out.println("Discount: 10% OFF !!!");
		}
		System.out.println("All the menu price: " + totalPrice);
	}

}
