package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Menu;

public interface OrderService2 {
	void setMenuNamePrice(Menu mapMenu);
	void orderMenu(String menu, int quantity);
	void getAllInfo();
}
