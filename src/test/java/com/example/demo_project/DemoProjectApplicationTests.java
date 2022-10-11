package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.service.ifs.Active;
import com.example.demo_project.service.ifs.OrderService;
import com.example.demo_project.service.impl.BirdServiceImpl;

@SpringBootTest
class DemoProjectApplicationTests {
	// 1007 Homework
	@Autowired
	private OrderService orderServiceTest;
	@Test
	public void orderServiceTest() {
		// set menu
		System.out.println();
		orderServiceTest.setMenuNamePrice("beef", 100);
		orderServiceTest.setMenuNamePrice("pork", 90);
		orderServiceTest.setMenuNamePrice("chicken", 80);
		System.out.println();
		
		// order menu (without discount)
//		orderServiceTest.orderMenu("beef", 1);
//		orderServiceTest.orderMenu("pork", 1);
//		orderServiceTest.orderMenu("chicken", 1);
//		System.out.println();
		
		// order menu (with discount)
		orderServiceTest.orderMenu("beef", 6);
		orderServiceTest.orderMenu("pork", 1);
		orderServiceTest.orderMenu("chicken", 1);
		System.out.println();
		
		// get all menu price
		orderServiceTest.getAllPrice();

	}
	
	
	
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
