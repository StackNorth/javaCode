package com.bjsxt.thread.create;

public class Robbit extends Thread {

	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("兔子跑了"+i+"步");
			
		}
	}
}

 class Tortoise extends Thread {

	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("乌龟跑了"+i+"步");
			
		}
	}
}
