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
public class Server {
	private ServerSocket server;
	public static void main(String[] args){
		Server server =new Server();
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
			String msg=null;//接收客户端的请求信息
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length()>0){
				sb.append(msg);
				sb.append("\r\n");
				if(msg==null){
					break;
				}
			}
			//接收客户端请求信息
			String requestInfo =sb.toString().trim();
			System.out.println(requestInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
	}
}
