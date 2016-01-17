package facetoproject.mywork;

public class Vehicle {
	private int speed;
	private String size;
	public void move(){
		System.out.println("i'm moving!");
	}
	
	public void setSpeed(int speed){
		System.out.println("my car's speed is " + speed);
	}
	
	public void speedUp(){
		Vehicle car = new Vehicle();
		car.setSpeed(160);
	}
	
	public void speedDown(){
		Vehicle car = new Vehicle();
		car.setSpeed(20);
	}
	public static void main(String[] args){
		Vehicle car = new Vehicle();
		car.speed = 100;
		car.size = "20";
		car.move();
		car.speedDown();
		car.speedUp();
	}
}
/*
 * public class Car {
	private int speed;
	private String size;
	public void move(){
		System.out.println("i'm moving!");
	}
	
	public void setSpeed(int speed){
		System.out.println("my car's speed is" + speed);
	}
	
	public void speedUp(int speed){
		Car c = new Car();
		speed = speed-50;
		c.setSpeed(speed);
	}
	
	public void speedDown(int speed){
		Car c = new Car();
		speed = speed+50;
		c.setSpeed(speed);
	}
	public static void main(String[] args){
		Car c = new Car();
		c.speed = 100;
		c.size = "20";
		c.move();
		c.speedDown(c.speed);
		c.speedUp(c.speed);
	}
}

 */
