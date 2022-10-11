package com.example.demo_project.service.impl;

public class Bird1 extends Animal {
	@Override
	public void move() {
		System.out.println("BirdABC");
		System.out.println("Bird is flying.");
	}

	public void birdmove(Bird1 bird) {

		bird.move();
	}
}
