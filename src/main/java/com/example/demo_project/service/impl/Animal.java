package com.example.demo_project.service.impl;

public class Animal {
	public void move() {
		System.out.println("Animal is moving.");
	}

	public void animove(Animal ani) {
		System.out.println("ABC");
		ani.move();
	}
}
