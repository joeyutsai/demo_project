package com.example.demo_project.service.ifs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.vo.Order;
import com.example.demo_project.vo.OrderReq;
import com.example.demo_project.vo.OrderRes;

public interface OrderService {
	public void setMenuNamePrice(String singleMenu, int singlePriceMenu);
	public void orderMenu(String menu, int quantity);
	public void getAllPrice();
	
	//classroomPractice_1019
	public OrderRes getTestMenu(OrderReq request);
	public OrderRes getTestPrice(OrderReq request);
	
	// * class_1020
//	public Map<String, Integer> getMenus = new HashMap<String, Integer>();
	public List<Menu> tgetMenu();
	public Menu ttgetMenu(String name);
	public Order torderMenu();
	public Order torderMenu(List<Menu> menuList);
	// * 1020class_1020
	

}
