package com.bjxst.net.tcp.chat.demo02;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
	//输入流
	private DataInputStream dis;
	//线程标识
	private boolean isRunning=true;
	public Receive() {
	}
	//构造器
	public Receive(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			isRunning =false;
			CloseUtil.Close(dis);
		}
		
	}
	//接收方法
	public String receive(){
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			isRunning =false;
			CloseUtil.Close(dis);
		}
		return msg;
	}
	
	public void run() {
		//线程体
		while(isRunning){
			System.out.println(receive());
		}
	}

}
