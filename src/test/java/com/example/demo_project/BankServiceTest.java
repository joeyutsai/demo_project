package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.controller.BankController;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;

@SpringBootTest
public class BankServiceTest {
	@Autowired
	private BankController bankController;
	@Test
	public void bankControllerTest() {
		
//		//classroom_1018
//		BankReq req = new BankReq();
//		req.setAccount("");
//		req.setAccount(" ");
//		req.setAccount("A01");
//		BankRes res = bankController.getAmount(req);
//		System.out.println(res.getAccount());
//		System.out.println(res.getAmount());
//		System.out.println(res.getMessage());
//
	}
}
