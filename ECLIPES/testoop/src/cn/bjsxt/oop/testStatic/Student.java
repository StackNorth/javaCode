package cn.bjsxt.oop.testStatic;

public class Student {
	//��̬������
	 String name;
	 int id;
	 int age;
	 String gender;
	 int weight;
	 
 
	 Computer computer;
	 //��̬����Ϊ
	 public void study(){
		 System.out.println(name + "��ѧϰ");
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