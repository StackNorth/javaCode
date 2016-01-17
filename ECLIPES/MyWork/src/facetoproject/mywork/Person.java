package facetoproject.mywork;

import java.awt.SystemTray;

public class Person {
	private String name;
	private int age;
	public Person(String name, int age){
		this.age = age;
		this.name = name;
	}
	
	public void diaplay(){
		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);	
	}
	
	public static void main(String[] args) {
		Person p = new Person("张三",18);//要与构造器一样
		p.diaplay();
	}
}
