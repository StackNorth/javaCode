package cn.bjsxt.oop.testStatic;
//方法的重载
public class TestOverload {
	public static void main(String[] args){
		MyMath m = new MyMath();
		int result = m.add(3, 4);
		System.out.println(result);
	}
}

//构造方法的重载
class MyMath {
	 int a;
	 int b;
	 public MyMath(){
		 
	 }
	 
	 
	 public MyMath(int a){
		this.a = a;
		
	}
	
	public MyMath(int a,int b){
		this.a = a;
		this.b = b;
	}
	
	
	public int add(int a, int b){
		
		return a+b;
	}
	
public int add(int a, int b, int c){
		
		return a+b+c;
	}
	
}