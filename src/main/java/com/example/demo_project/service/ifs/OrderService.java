package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Menu;

public interface OrderService {
	void setMenuNamePrice(String singleMenu, int singlePriceMenu);
	void orderMenu(String menu, int quantity);
	void getAllPrice();
}
