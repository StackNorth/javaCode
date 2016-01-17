package cn.bjsxt.oop.testStatic;

public class Test2 {
	public static void main(String[] args){
		Student s1 = new Student();
		s1.name = "gaoqi";
		s1.age = 18;
		
		Computer c = new Computer();
		c.brand = "lianxiang";
		c.cpuSpeed = 100;
		
		s1.computer = c;
		c.brand = "dell";
	//	System.out.println(s1.computer.brand );
		
		String str1 = "dell";
		System.out.println(str1 == c.brand );
		
	}
}
