package cn.bjsxt.oop.testinterface;

public class MyClass implements MyInterface{
	public void test01() {

		System.out.println("test01");
		
	}

	public int test02(int a, int b) {
		System.out.println("maclass.test02");
		return a+b;
	}

}
