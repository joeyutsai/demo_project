package com.example.demo_project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Register;
import com.example.demo_project.service.ifs.RegisterService;

@SpringBootTest
public class RegisterAOPTest {
	@Autowired
	private RegisterService registerService;

	@Test
	public void findAll() {
		// before
		List<Register> result = registerService.findAll();
		// after
		System.out.println(result.size());
	}
}
