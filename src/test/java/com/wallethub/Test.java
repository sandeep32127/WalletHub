package com.wallethub;

public class Test{
	static int b[];
	public static void main(String[] args) {
		String sup = "asdadsfgfgfgf";
		String[] split = sup.split("");
		System.out.println(split.toString());
		//System.out.println(b.length);
		
		/*Car c = new Car(200);
		c.drive();*/
		
		Vehicle v = new Car();
		v.race();
		v.speed();
		v.vehicleRun();
		System.out.println("The max speed is :"+v.maxSpeed);
		
		Car c = new Car();
		c.race();
		c.speed();
		c.carRun();
		c.vehicleRun();
		System.out.println("The max speed is :"+c.maxSpeed);
		
		Vehicle v1 = new Vehicle();
		v1.race();
		v1.speed();
		System.out.println("The max speed is :"+v1.maxSpeed);
		
		Car c2 = (Car) new Vehicle();
		c2.vehicleRun();
		c2.carRun();
		c2.race();
		c2.speed();
		System.out.println("The max speed is :"+c2.maxSpeed);
	}
	
}
