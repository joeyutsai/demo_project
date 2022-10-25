package com.example.demo_project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.MenuRes;
import com.example.demo_project.vo.Order;
import com.example.demo_project.vo.OrderReq;
import com.example.demo_project.vo.OrderRes;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/api/getTestMenu")
	public OrderRes getTestMenu(@RequestBody OrderReq req) {
		Map<String, Integer> testListMenu = new HashMap<String, Integer>();
		testListMenu.put("beef", 100);
		testListMenu.put("pork", 90);
		testListMenu.put("chicken", 80);

		OrderRes res = new OrderRes();

		if (!StringUtils.hasText(req.getName())) {
			res.setMessage("Error! Name is empty.");
			return res;
		}  
			
		res.setName(req.getName());
		res.setPrice(testListMenu.get(req.getName()));
		res.setMessage("Sucessful");
		return res;

	}

	@PostMapping(value = "/api/getTestPrice")
	public OrderRes getTestPrice(@RequestBody OrderReq req) {
		Map<String, Integer> testListMenu = new HashMap<String, Integer>();
		testListMenu.put("beef", 100);
		testListMenu.put("pork", 90);
		testListMenu.put("chicken", 80);

		OrderRes res = new OrderRes();

		int testTotalPrice = testListMenu.get(req.getName()) * req.getQuantity();
		res.setName(req.getName());
		res.setPrice(req.getPrice());
		res.setQuantity(req.getQuantity());
		res.setMessage("Sucessful!" + " TOTAL PRICE: $" + testTotalPrice);

		return res;

	}

	
	// * START classroomRead_Homework1019_1020
	
	// API1_method1_withStaticGetMenu
	@PostMapping(value = "/api/tgetMenu")
	public MenuRes tgetMenu(@RequestBody OrderReq req) {
		List<Menu> menuList = orderService.tgetMenu();
		MenuRes res = new MenuRes(menuList);
		return res;
	}
	
	// API1_method2_withDynamicGetMenu
	@PostMapping(value = "/api/ttgetMenu")
	public Menu ttgetMenu(@RequestBody OrderReq req) {
		Menu menu = orderService.ttgetMenu(req.getName());
		return menu;
	}
	
	// API2_method1_withStaticOrderMenu
	@PostMapping(value = "/api/torderMenu")
	public Order torderMenu() {
		return orderService.torderMenu();
	}
	
	// API2_method2_withDynamicOrderMenu
	@PostMapping(value = "/api/ttorderMenu")
	public Order ttorderMenu() {
		return null;
	}
	// * END classroomRead_Homework1019_1020

}
