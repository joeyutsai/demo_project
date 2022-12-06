package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.repository.OrderDao;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.vo.MenuRes;
import com.example.demo_project.vo.Order;
import com.example.demo_project.vo.OrderAllRes;
import com.example.demo_project.vo.OrderReq;
import com.example.demo_project.vo.OrderRes;

@RestController
public class OrderController {
	// START homework_1025

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/api/addMenu")
	public OrderRes addMenu(@RequestBody OrderReq req) {
		return orderService.addMenu(req.getName(), req.getPrice());
	}

	@PostMapping(value = "/api/getAllMenu")
	public List<Menu> getAllMenu() {
		return orderDao.findAll();
	}

	@PostMapping(value = "/api/getMenu")
	public Menu getMenu(@RequestBody OrderReq req) {
		return orderDao.findById(req.getName()).orElse(new Menu());
	}

	@PostMapping(value = "/api/orderMenu")
	public OrderRes orderMenu(@RequestBody List<OrderReq> orderList) {
		OrderRes res = new OrderRes();
		List<OrderRes> resList = new ArrayList<OrderRes>();
		int totPrice = 0;
		int quantityMenu = 0;
		
		for (OrderReq item : orderList) {
			Menu putMenu = orderDao.findById(item.getName()).orElse(new Menu());

			if (item.getQuantity() > 0) {
				quantityMenu = item.getQuantity();
			}

			if (!StringUtils.hasText(item.getName())) {
				OrderRes putRes = new OrderRes("ERROR. Null or Empty", 0, 0);
				resList.add(putRes);
			} else {
				OrderRes putRes = new OrderRes(putMenu.getName(), putMenu.getPrice(), quantityMenu);
				totPrice += putMenu.getPrice() * quantityMenu;
				resList.add(putRes);
			}
			
		}

		if (totPrice > 500) {
			totPrice = (int) (0.9 * totPrice);
		}

		res.setMessage("totPrice: $" + totPrice);
		res.setAllList(resList);
		return res;
	}

	// END homework_1025

//	@Autowired
//	private OrderService orderService;
//
//	@PostMapping(value = "/api/getTestMenu")
//	public OrderRes getTestMenu(@RequestBody OrderReq req) {
//		Map<String, Integer> testListMenu = new HashMap<String, Integer>();
//		testListMenu.put("beef", 100);
//		testListMenu.put("pork", 90);
//		testListMenu.put("chicken", 80);
//
//		OrderRes res = new OrderRes();
//
//		if (!StringUtils.hasText(req.getName())) {
//			res.setMessage("Error! Name is empty.");
//			return res;
//		}  
//			
//		res.setName(req.getName());
//		res.setPrice(testListMenu.get(req.getName()));
//		res.setMessage("Sucessful");
//		return res;
//
//	}
//
//	@PostMapping(value = "/api/getTestPrice")
//	public OrderRes getTestPrice(@RequestBody OrderReq req) {
//		Map<String, Integer> testListMenu = new HashMap<String, Integer>();
//		testListMenu.put("beef", 100);
//		testListMenu.put("pork", 90);
//		testListMenu.put("chicken", 80);
//
//		OrderRes res = new OrderRes();
//
//		int testTotalPrice = testListMenu.get(req.getName()) * req.getQuantity();
//		res.setName(req.getName());
//		res.setPrice(req.getPrice());
//		res.setQuantity(req.getQuantity());
//		res.setMessage("Sucessful!" + " TOTAL PRICE: $" + testTotalPrice);
//
//		return res;
//
//	}
//
//	
//	// * START classroomRead_Homework1019_1020
//	
//	// API1_method1_withStaticGetMenu
//	@PostMapping(value = "/api/tgetMenu")
//	public MenuRes tgetMenu(@RequestBody OrderReq req) {
//		List<Menu> menuList = orderService.tgetMenu();
//		MenuRes res = new MenuRes(menuList);
//		return res;
//	}
//	
//	// API1_method2_withDynamicGetMenu
//	@PostMapping(value = "/api/ttgetMenu")
//	public Menu ttgetMenu(@RequestBody OrderReq req) {
//		Menu menu = orderService.ttgetMenu(req.getName());
//		return menu;
//	}
//	
//	// API2_method1_withStaticOrderMenu
//	@PostMapping(value = "/api/torderMenu")
//	public Order torderMenu() {
//		return orderService.torderMenu();
//	}
//	
//	// API2_method2_withDynamicOrderMenu
//	@PostMapping(value = "/api/ttorderMenu")
//	public Order ttorderMenu() {
//		return null;
//	}
//	// * END classroomRead_Homework1019_1020

}
