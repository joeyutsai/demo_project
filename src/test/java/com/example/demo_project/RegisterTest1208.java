package com.example.demo_project;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.RegisterRes;

@SpringBootTest
public class RegisterTest1208 {
	@Autowired
	private RegisterService registerService;
	
	@Test
	public void activeAccount2Test() {
//		if (req.getVerifyCode() == 0) {
//			return new RegisterRes("Please enter verify code.");
//		}
//
//		if (req.getVerifyCode() == (int) httpSession.getAttribute("user_verify_code")) {
//			System.out.println("Correct.");
//		}

	}
	
	
	@Test
	public void httpSessionSetTest() {
		int verifyCode = randomDigitsTest();
		HttpSession httpSession = null;
		httpSession.setAttribute("user_verify_code", verifyCode);
		Object revealVerifyCode = httpSession.getAttribute("user_verify_code");

		if (!StringUtils.hasText(revealVerifyCode.toString())) {
			System.out.println("User verify code is empty.");

		}
		
		System.out.println("--> httpSession Get user verify code: "+revealVerifyCode);

	}

	// get random digits range from 1 ~ xxxx
	@Test
	public int randomDigitsTest() {
		int verifyCode = produceRandomVerifyCode();

		while (verifyCode == 0) {
			verifyCode = produceRandomVerifyCode();
		}

		System.out.println(verifyCode);

		return verifyCode;
	}

	public int produceRandomVerifyCode() {
		double random = Math.random() * 10000;
		int verifyCode = (int) Math.round(random);
		return verifyCode;
	}
}
