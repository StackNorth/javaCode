package cn.bjsxt.oop.abstractClass;

public abstract class Animal {
	public abstract/*���󷽷�*/ void run();
	public void bresath(){
		System.out.println("hu");
	}
	
}

class Cat extends Animal{

	@Override
	public void run() {
	System.out.println("è��С��");
		
	}

}

class Dog extends Animal{

	@Override
	public void run() {
		System.out.println("è��С��");
	}
	
}