package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.service.ifs.Active;

@Service("A1") //alias (hot code)
public class BirdServiceImpl implements Active {

	@Override
	public Bird fly(String name, int age) {
		Bird birdd = new Bird();
		birdd.setName(name);
		birdd.setAge(age);
		System.out.println("A1 Qualifier");
		return birdd;
	}
	
	@Override
	public void printFly(Bird bird) {
		System.out.println(bird.getName() + " is flying. Bird age : "+ bird.getAge());
	}

}
