package cn.bjsxt.oop.encapsulation;

public class Test01 {
	private String 	str;
	protected void print(){
		System.out.println("test01.print");
		
	}
}

class Test001 extends Test01{
	public void aa(){
		print();
	}
	
}