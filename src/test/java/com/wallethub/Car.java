package com.wallethub;

public class Car extends Vehicle{
	
	/*Car(int minSpeed){
		//super(minSpeed);
		super.minSpeed = minSpeed;
		System.out.println("inside child class");
	}*/
	
	public void drive() {
		System.out.println("The minimum speed car is : "+minSpeed);
	}

	int maxSpeed = 180;
	public static void race() {
		System.out.println("The car is racing");
	}

	public void speed() {
		System.out.println("The car is running at :"+maxSpeed);
	}

	public void carRun() {
		System.out.println("The car runs");
	}

}
