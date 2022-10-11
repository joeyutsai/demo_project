package com.example.demo_project.service.impl;

public class Cat extends Animal {
	@Override
	public void move() {
		System.out.println("CatABC");
		System.out.println("Cat is jumping.");
	}

	public void catmove(Cat cat) {

		cat.move();
	}
}
