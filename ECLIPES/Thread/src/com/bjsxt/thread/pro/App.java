package com.bjsxt.thread.pro;

public class App {
	public static void main(String[] args) {
		//��ͬ����Դ
		Movie m=new Movie();
		//���߳�
		player p= new player(m);
		viewer v= new viewer(m);
		
		new Thread(p).start();
		new Thread(v).start();
	}
}
