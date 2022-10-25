package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.Order;
import com.example.demo_project.vo.OrderReq;
import com.example.demo_project.vo.OrderRes;

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

	// START classroomPractice_1019
	@Override
	public OrderRes getTestMenu(OrderReq req) {
		Map<String, Integer> testListMenu = new HashMap<String, Integer>();
		testListMenu.put("beef", 100);
		testListMenu.put("pork", 90);
		testListMenu.put("chicken", 80);

		OrderRes res = new OrderRes();

		res.setName(req.getName());
		res.setPrice(testListMenu.get(req.getName()));
		res.setMessage("Sucessful");

		return res;
	}

	@Override
	public OrderRes getTestPrice(OrderReq req) {
		Map<String, Integer> testListMenu = new HashMap<String, Integer>();
		testListMenu.put("beef", 100);
		testListMenu.put("pork", 90);
		testListMenu.put("chicken", 80);
		OrderRes res = new OrderRes();

		int testTotalPrice = testListMenu.get(req.getName()) * req.getQuantity();
		res.setName(req.getName());
		res.setPrice(testTotalPrice);
		res.setMessage("Sucessful");

		return res;

	}
	// END classroomPractice_1019

	// * START classroomTeach_Homework_1019_1020

	// initial
	private Menu beef = new Menu("beef", 100, 5);
	private Menu pork = new Menu("pork", 90, 6);
	private Menu chicken = new Menu("chicken", 80, 3);

	@Override
	public List<Menu> tgetMenu() {
		// find all menus from DB
		List<Menu> list = new ArrayList<>();
		list.add(beef);
		list.add(pork);
		list.add(chicken);

		return list;
	}

	@Override
	public Menu ttgetMenu(String name) {
		// initial
		Menu beefMenu = new Menu("beef", 100);
		Menu porkMenu = new Menu("pork", 90);
		Menu chickenMenu = new Menu("chicken", 80);
		// find menu by name
		if (name.equalsIgnoreCase(beefMenu.getName())) {
			return beefMenu;
		} else if (name.equalsIgnoreCase(porkMenu.getName())) {
			return porkMenu;
		} else if (name.equalsIgnoreCase(chickenMenu.getName())) {
			return chickenMenu;
		} else {
			return new Menu();
		}

	}

	@Override
	public Order torderMenu(List<Menu> menuList) {
		int totalPrice = 0;
		for (Menu item : menuList) {
			totalPrice += item.getQuantity() * item.getQuantity();
		}
		Order result = new Order(menuList, totalPrice);
		return result;
	}

	@Override
	public Order torderMenu() {

		List<Menu> menuList = tgetMenu();

		int totalPrice = 0;

		for (Menu item : menuList) {
			totalPrice += item.getQuantity() * item.getQuantity();
		}

		Order result = new Order(menuList, totalPrice);

		return result;
	}

	// * END classroomTeach_Homework_1019_1020

}
