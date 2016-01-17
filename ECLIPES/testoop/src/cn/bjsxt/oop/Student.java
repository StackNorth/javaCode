package cn.bjsxt.oop;

public class Student {
	//静态的数据
	 String name;
	 int id;
	 static int ss;//从属于对象，
	 
	 public static void printSS(){
		 System.out.println(ss);
		 
	 }

	 public void study(){
		 System.out.println(name + "在学习");
	 }
	 public void sayhello(String sname){
		 System.out.println(sname+"hi,nihao!");
	 }
	 public static void main(String[] args){
		 Student s1 = new Student();
		 s1.name = "dnegtao";
		 s1.study();
		 s1.sayhello("lilifeng");
	 }
}
