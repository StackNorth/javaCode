package cn.bjsxt.oop.Final;

public /*final*/ class Animal {//final修饰类则说明这个类不能被继承
	public void run(){
		System.out.println("benbao");//final加到方法前面，意味着该方法不能被子类重写
	}
	
	
}


class Brid extends Animal {
	public void run(){
		super.run();
		System.out.println("feixiang ");

	}
}
	