package cn.bjsxt.oop.inherit;

public class Animal2 {
	String eye; 
	public void run(){
		System.out.println("benbao");
	}
	
	public void eat(){
		System.out.println("chifan");
	}
	public void sleep(){
		System.out.println("shuijioa");
	}
	public Animal2(){
		super();
		System.out.println("chuange a animal");
	}
	
	public static void main(String[] args){
		Brid2 b = new Brid2();
		b.run();
		
	}
}

class Mammal2 {
	Animal2 animal2 = new Animal2();
	public void taisheng(){
			System.out.println("胎生");
		}
	}

class Brid2 {
/**
 * 方法的重写  	
 */
	Animal2 animal2 = new Animal2();
	public void run(){
		animal2.run();
		System.out.println("feixiang ");

	}
	
	public void egg(){
		
		System.out.println("luansheng");
	}
	
	public Brid2(){
		super();
		System.out.println("changjianniaodeduixiang");
		
	}
}

