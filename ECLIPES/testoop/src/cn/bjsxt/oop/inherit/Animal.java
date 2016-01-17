package cn.bjsxt.oop.inherit;
/**
 * 继承
 * @author llf
 *
 */
public class Animal {
	String eye; 
	public void run(){
		System.out.println("benbao");
	}
	
	public void eat(){
		System.out.println("chifan");
	}
}

class Mammal extends Animal {

	public void taisheng(){
		this.run();
			System.out.println("胎生");
		}
	}

class Brid extends Animal {
/**
 * 方法的重写  	
 */
	public void run(){
		super.run();
		System.out.println("feixiang ");

	}
	
	class Mammal extends Animal {

		public void taisheng(){
			this.run();
				System.out.println("胎生");
			}
		}

	class brid extends Animal {
	/**
	 * 方法的重写  	
	 */
		public void run(){
	
			System.out.println("feixiang ");

		}
		
		public void egg(){
			System.out.println("luansheng");
		}
	}

	public void egg(){
		System.out.println("luansheng");
	}
}

