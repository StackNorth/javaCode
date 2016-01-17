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
 * ������������������
 * ������Ӧ
 *
 */
public class Server4 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private String BLANK=" ";
	public static void main(String[] args){
		Server4 server =new Server4();
		server.start();
		
	}
	/**
	 * ����������
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
	 * ������������
	 */
	private void receive(){
		try {
			Socket client=server.accept();
			Request req= new Request(client.getInputStream());
			
			
			Response rep=new Response(client.getOutputStream());
			rep.println("<html><head><title>HTTP��Ӧ����</title>");
			rep.println("</head><body>������ѧ�û�ӭ��!</body></html>");
			rep.pushToClient(200);
			
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
	}
}
