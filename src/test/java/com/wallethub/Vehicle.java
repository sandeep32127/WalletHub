package com.wallethub;

public class Vehicle {
	int maxSpeed = 200;
	int minSpeed;
	
	Vehicle(int minSpeed){
		this.minSpeed = minSpeed;
	}
	Vehicle(){
		System.out.println("");
	}
	
	public void drive() {
		System.out.println("The minimum speed for base class is : "+minSpeed);
	}

	public static void race() {
		System.out.println("Te vehicle is racing");
	}

	public void speed() {
		System.out.println("The vehicle is running at : "+maxSpeed);
	}
	
	public void vehicleRun() {
		System.out.println("The vehicle runs");
	}
}
