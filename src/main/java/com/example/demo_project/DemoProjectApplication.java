package com.example.demo_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.service.impl.BirdServiceImpl;
import com.example.demo_project.service.impl.PersonServiceImpl;

@SpringBootApplication

public class DemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
					
		// 1006HOMEWORK
//		BirdServiceImpl birdService = new BirdServiceImpl();
//		Bird printBird = birdService.fly("BigHeadBird", 3);
//		birdService.printFly(printBird);
		
		// 1006Classroom
//		PersonServiceImpl personservice = new PersonServiceImpl();
//		Person per = personservice.getPersonInfo("009876", "Tom", 23, "Tainan");
//		personservice.printPersonInfo(per);
		
	}

}
