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
		System.out.println("������" + name);
		System.out.println("���䣺" + age);	
	}
	
	public static void main(String[] args) {
		Person p = new Person("����",18);//Ҫ�빹����һ��
		p.diaplay();
	}
}
