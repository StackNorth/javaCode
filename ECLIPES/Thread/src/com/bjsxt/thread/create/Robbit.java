package com.bjsxt.thread.create;

public class Robbit extends Thread {

	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("��������"+i+"��");
			
		}
	}
}

 class Tortoise extends Thread {

	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("�ڹ�����"+i+"��");
			
		}
	}
}
