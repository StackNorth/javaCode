package com.bjsxt.thread.create;

import java.net.Proxy;

public class ProgramApp {
	public static void main(String[] args) {
		//������ʵ��ɫ
		Program pro=new Program();
		//���������ɫ+��ʵ��ɫ������
		Thread proxy=new Thread(pro);
		//���÷����������߳�
		proxy.start();
		for(int i=0;i<100;i++){
			System.out.println("һ����qq"+i);
		}
	}
		
}
