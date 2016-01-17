package com.bjsxt.thread.create;

import java.net.Proxy;

public class ProgramApp {
	public static void main(String[] args) {
		//创建真实角色
		Program pro=new Program();
		//创建代理角色+真实角色的引用
		Thread proxy=new Thread(pro);
		//调用方法，启动线程
		proxy.start();
		for(int i=0;i<100;i++){
			System.out.println("一边聊qq"+i);
		}
	}
		
}
