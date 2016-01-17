package cn.bjsxt.oop.testThis;

public class Student {
	 String name;
	 int id;
	 
	 public Student(String name,int id){
		 this(); // 通过this调用其他的构造方法
		 //必须位于第一句   Constructor call must be the first statement in a constructor
		 this.name = name;
		 this.id = id;
	
		 }
	 
	 public Student(){
		 System.out.println("gouzaoyigefnagga");
		 
	 }
	 
	 public void study(){
		 
		 this.name = "zhangsan";	
		 System.out.println(name + "在学习");
	 }
	 
	 public void sayhello(String sname){
		 System.out.println(sname+"hi,nihao!");
	 }
}