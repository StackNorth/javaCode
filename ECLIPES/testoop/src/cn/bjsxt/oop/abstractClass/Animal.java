package cn.bjsxt.oop.abstractClass;

public abstract class Animal {
	public abstract/*抽象方法*/ void run();
	public void bresath(){
		System.out.println("hu");
	}
	
}

class Cat extends Animal{

	@Override
	public void run() {
	System.out.println("猫步小炮");
		
	}

}

class Dog extends Animal{

	@Override
	public void run() {
		System.out.println("猫步小炮");
	}
	
}