package com.bjxst.server.demo01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器，并启动
 * @author llf
 *
 */
public class Server2 {
	private ServerSocket server;
	public static void main(String[] args){
		Server2 server =new Server2();
		server.start();
		
	}
	/**
	 * 创建服务器
	 */
	public void start(){
		 try {
			server =new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 用来接收数据
	 */
	private void receive(){
		try {
			Socket client=server.accept();
			StringBuilder sb =new StringBuilder();
			byte[] data=new byte[20480];
			int len=client.getInputStream().read(data); //读取的数值从输入流存入data中
			//接收客户端请求信息
			String requestInfo =new String(data,0,len).trim();
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
	}
}
