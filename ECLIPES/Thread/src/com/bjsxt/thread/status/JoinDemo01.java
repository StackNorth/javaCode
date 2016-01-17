 package com.bjsxt.thread.status;
/**
 * join合并线程
 * @author llf
 *
 */
public class JoinDemo01 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 demo =new JoinDemo01();
		Thread t= new Thread(demo);
		t.start();
		for(int i=0;i<100;i++){
			if(i==50)
				t.join();//main方法阻塞
			System.out.println("main....."+i);
		}
	}
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("join...."+i);
		}
	}
}
