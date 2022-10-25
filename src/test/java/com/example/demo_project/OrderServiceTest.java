package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.service.ifs.OrderService;

@SpringBootTest
public class OrderServiceTest {
//1007 Homework
	@Autowired
	private OrderService orderServiceTest;
	@Test
	public void orderServiceTest() {
//		 set menu
		System.out.println();
		orderServiceTest.setMenuNamePrice("beef", 100);
		orderServiceTest.setMenuNamePrice("pork", 90);
		orderServiceTest.setMenuNamePrice("chicken", 80);
		orderServiceTest.setMenuNamePrice("fish", 120);
		System.out.println();
//	     order menu (without discount)
		orderServiceTest.orderMenu("beef", 1);
		orderServiceTest.orderMenu("pork", 1);
		orderServiceTest.orderMenu("chicken", 1);
		System.out.println();
//	     order menu (with discount)
		orderServiceTest.orderMenu("beef", 6);
		orderServiceTest.orderMenu("pork", 1);
		orderServiceTest.orderMenu("chicken", 1);
		orderServiceTest.orderMenu("fish", 10);
		System.out.println();	
//	     get all menu price
		orderServiceTest.getAllPrice();
	}
	
}
