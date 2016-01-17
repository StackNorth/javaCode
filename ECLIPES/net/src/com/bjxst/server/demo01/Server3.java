package com.bjxst.server.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 创建服务器，并启动
 * 请求并响应
 *
 */
public class Server3 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private String BLANK=" ";
	public static void main(String[] args){
		Server3 server =new Server3();
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
			
			//响应
			StringBuilder responseContent =new StringBuilder();
			//正文信息
			responseContent.append("<html><head><title>HTTP响应事例</title>"+
			"</head><body>北京尚学堂欢迎您!</body></html>");
			StringBuilder response=new StringBuilder();
			//HTTP协议版本、状态代码、描述
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(BLANK);
			//响应头（response head）
			response.append("Server:bjxst Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK;").append(CRLF);
			//正文长度，字节长度
			response.append("Content-Length:").append(responseContent.toString().getBytes().length).append(CRLF);
			//正文之前
			response.append(CRLF);
			//正文
			response.append(responseContent);
			
			
			//输出流
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
	}
}
