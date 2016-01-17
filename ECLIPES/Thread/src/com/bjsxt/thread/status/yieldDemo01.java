package com.bjsxt.thread.status;

public class yieldDemo01 extends Thread{
	public static void main(String[] args) {
		yieldDemo01 demo =new yieldDemo01();
		Thread t= new Thread(demo);
		t.start();
		for(int i=0;i<100;i++){
			if(i%20==0)
				Thread.yield();//暂停当前线程main
			System.out.println("main....."+i);
		}
	}
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("join...."+i);
		}
	}
		
}
