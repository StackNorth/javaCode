package cn.bjsxt.oop.testThis;

public class Student {
	 String name;
	 int id;
	 
	 public Student(String name,int id){
		 this(); // ͨ��this���������Ĺ��췽��
		 //����λ�ڵ�һ��   Constructor call must be the first statement in a constructor
		 this.name = name;
		 this.id = id;
	
		 }
	 
	 public Student(){
		 System.out.println("gouzaoyigefnagga");
		 
	 }
	 
	 public void study(){
		 
		 this.name = "zhangsan";	
		 System.out.println(name + "��ѧϰ");
	 }
	 
	 public void sayhello(String sname){
		 System.out.println(sname+"hi,nihao!");
	 }
}