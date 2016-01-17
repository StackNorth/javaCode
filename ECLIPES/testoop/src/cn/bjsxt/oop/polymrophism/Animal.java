package cn.bjsxt.oop.polymrophism;

public class Animal {
	public void voice(){
		System.out.println("普通动物的叫声");
	}	
	
	public  void catchMouse(){
		System.out.println("zhualaoshu");
	}
	
}

class Cat extends Animal{
	public void voice(){
		System.out.println("miaomiao");
	}
	
}

class Pig extends Animal{
	public void voice(){
		System.out.println("hengheng");
	}
}

class Dog extends Animal{
	public void voice(){
		System.out.println("ww");
	}
}