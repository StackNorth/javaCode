package com.bjxst.server.demo03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.bjxst.net.tcp.chat.demo03.CloseUtil;

/**
 * 创建服务器，并启动
 * 请求并响应
 *
 */
public class Server {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private String BLANK=" ";
	private boolean isShutDown =false;
	public static void main(String[] args){
		Server server =new Server();
		server.start();	
	}
	/**
	 * 创建服务器
	 */
	public void start(){
		 start(8888);
	}
	public void start(int port){
		 try {
			server =new ServerSocket(port);
			this.receive();
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
		
	}
	/**
	 * 用来接收数据
	 */
	private void receive(){
		try {
			while(!isShutDown){
				new Thread(new Dispatcher(server.accept())).start();
			}
		} catch (IOException e) {
			//e.printStackTrace();
			stop();
		}
		
	}
	
	public void stop(){
		isShutDown = true;
		CloseUtil.CloseSocket(server);
	}
}
