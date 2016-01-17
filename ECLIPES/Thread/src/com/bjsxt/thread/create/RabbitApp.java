package com.bjsxt.thread.create;

public class RabbitApp {
	public static void main(String[] args) {
		Robbit rb=new Robbit();
		Tortoise to=new Tortoise();
		to.start();
		rb.start();
		for(int i=0;i<100;i++){
			System.out.println("main==>"+i);
			
		}
	}
}
