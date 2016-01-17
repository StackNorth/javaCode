package facetoproject.mywork.Auto;

public abstract class Vehicle {
	 public abstract void  NoOfWheels();
}
class car extends Vehicle{
	public void NoOfWheels() {
	System.out.println("i'm a car");
	}
}
class Motorbike extends Vehicle{
	public void NoOfWheels() {
	System.out.println("i'm a Motorbike");
	}
}

class test {
	public static void main(String[] args) {
		car c = new car();
		c.NoOfWheels();
		Motorbike m = new Motorbike();
		m.NoOfWheels();
	}
}