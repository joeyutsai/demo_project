package com.example.demo_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo_project.entity.Users;
import com.example.demo_project.repository.UsersDao;

@SpringBootTest
public class UsersTest {
	@Autowired
	private UsersDao usersDao;

	@Test
	public void addUsers() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Users item1 = new Users("AA123", encoder.encode("aaa123"), "admin", true);
		Users item2 = new Users("BB123", encoder.encode("bbb123"), "user", true);
		Users item3 = new Users("CC123", encoder.encode("ccc123"), "user", true);
		Users item4 = new Users("DD123", encoder.encode("ddd123"), "user", false);
		List<Users> listUsers = Arrays.asList(item1, item2, item3, item4);
		usersDao.saveAll(listUsers);

//		List<Users> listUsers = new ArrayList<>();
//		Users item1 = new Users();
//		item1.setUserName("AA123");
//		item1.setPassword(encoder.encode("aaa123"));
//		item1.setRole("admin");
//		item1.setActive(true);
//		listUsers.add(item1);
//		
//		Users item2 = new Users();
//		item2.setUserName("BB123");
//		item2.setPassword(encoder.encode("bbb123"));
//		item2.setRole("user");
//		item2.setActive(true);
//		listUsers.add(item2);
//		
//		Users item3 = new Users();
//		item3.setUserName("CC123");
//		item3.setPassword(encoder.encode("ccc123"));
//		item3.setRole("user");
//		item3.setActive(true);
//		listUsers.add(item3);
//		
//		Users item4 = new Users();
//		item4.setUserName("DD123");
//		item4.setPassword(encoder.encode("ddd123"));
//		item4.setRole("user");
//		item4.setActive(false);
//		listUsers.add(item4);
//		usersDao.saveAll(listUsers);
	}
}
