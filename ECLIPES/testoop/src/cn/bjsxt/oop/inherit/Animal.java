package cn.bjsxt.oop.inherit;
/**
 * �̳�
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
			System.out.println("̥��");
		}
	}

class Brid extends Animal {
/**
 * ��������д  	
 */
	public void run(){
		super.run();
		System.out.println("feixiang ");

	}
	
	class Mammal extends Animal {

		public void taisheng(){
			this.run();
				System.out.println("̥��");
			}
		}

	class brid extends Animal {
	/**
	 * ��������д  	
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

