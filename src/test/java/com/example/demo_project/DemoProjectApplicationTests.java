package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.Active;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.service.ifs.OrderService2;
import com.example.demo_project.service.impl.BirdServiceImpl;

@SpringBootTest
class DemoProjectApplicationTests {
	@Autowired
	private OrderService2 orderService2Test;
	@Test
	public void orderService2Test() {
		System.out.println();
		// set menu
		Menu beefMenu = new Menu("beef", 100);
		Menu porkMenu = new Menu("pork", 90);
		Menu chickenMenu = new Menu("chicken", 80);
		orderService2Test.setMenuNamePrice(beefMenu);
		orderService2Test.setMenuNamePrice(porkMenu);
		orderService2Test.setMenuNamePrice(chickenMenu);
		System.out.println();
		// order menu
		orderService2Test.orderMenu("beef", 5);
		orderService2Test.orderMenu("pork", 1);
		orderService2Test.orderMenu("chicken", 1);
		System.out.println();
		// get all info
		orderService2Test.getAllInfo();
	}
	
	
	
//// 1007 Homework
//	@Autowired
//	private OrderService orderServiceTest;
//	@Test
//	public void orderServiceTest() {
////		 set menu
//		System.out.println();
//		orderServiceTest.setMenuNamePrice("beef", 100);
//		orderServiceTest.setMenuNamePrice("pork", 90);
//		orderServiceTest.setMenuNamePrice("chicken", 80);
//		orderServiceTest.setMenuNamePrice("fish", 120);
//		System.out.println();
////	     order menu (without discount)
//		orderServiceTest.orderMenu("beef", 1);
//		orderServiceTest.orderMenu("pork", 1);
//		orderServiceTest.orderMenu("chicken", 1);
//		System.out.println();
////	     order menu (with discount)
//		orderServiceTest.orderMenu("beef", 6);
//		orderServiceTest.orderMenu("pork", 1);
//		orderServiceTest.orderMenu("chicken", 1);
//		orderServiceTest.orderMenu("fish", 10);
//		System.out.println();	
////	     get all menu price
//		orderServiceTest.getAllPrice();
//	}
	
	
	
	// 1007 classroom
//	@Qualifier("A1") //hot code
//	@Autowired
//	private Active activeTest;
//	@Test
//	public void activeTest() {
//		activeTest.printFly(activeTest.fly("Alice", 8));
//	}
	
//	@Test
//	void contextLoads() {
//		
//	}
	
}
