package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.service.ifs.Active;
import com.example.demo_project.service.impl.BirdServiceImpl;

@SpringBootTest
class DemoProjectApplicationTests {
	@Autowired
	private Active activeTest;
	
	@Test
	public void activeTest() {
		activeTest.printFly(activeTest.fly("Alice", 8));
	}
	
//	@Test
//	void contextLoads() {
//		
//	}
	
}
