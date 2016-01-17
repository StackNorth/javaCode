package com.bjsxt.thread.pro;

public class App {
	public static void main(String[] args) {
		//共同的资源
		Movie m=new Movie();
		//多线程
		player p= new player(m);
		viewer v= new viewer(m);
		
		new Thread(p).start();
		new Thread(v).start();
	}
}
