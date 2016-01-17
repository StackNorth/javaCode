package cn.bjsxt.oop.testinterface;

public interface flyable {
	int max_speed = 10000;
	int min_height = 0;
	public void fly();
}
  

interface Attack{
	void attack();
}

class Plane implements flyable{
	
	public void fly(){
		System.out.println("feu");
		
	}
}