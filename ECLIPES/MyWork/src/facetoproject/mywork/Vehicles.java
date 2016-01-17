package facetoproject.mywork;

public class Vehicles {
	String brand;//商标
	String color;//颜色
	public void run(){//行驶
		System.out.println("我已经开动了");
	}
	
	public void showInfo(){
		System.out.println("商标" + this.brand + "颜色" + this.color);
	}
	
	public Vehicles(String brand,String color){
		this.brand = brand;
		this.color = color;
	}
	public static void main(String[] args) {
		Vehicles  v = new Vehicles("bmw","yellow");
		v.showInfo();
		car c = new car("qq","red",4);
		c.showInfo();
		Truck t = new Truck("byd","white",50000);
		t.showTruck();
	}
	
}


class car extends Vehicles{
	int sets;
	public void showCar(){
		System.out.println(brand + color + sets);
	}
	 
	public car(String brand ,String color ,int sets){
		super(brand,color);
		this.sets = sets;
	}
}

class Truck extends Vehicles{
	float load;
	public void showTruck(){
		System.out.println(brand + color + load);
	}
	public Truck(String brand ,String color ,float load){
		super(brand,color);
		this.load = load;
	}
}