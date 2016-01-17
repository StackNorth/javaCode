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
public class Server6 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private String BLANK=" ";
	public static void main(String[] args){
		Server6 server =new Server6();
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
			Servlet serv=new Servlet();
			serv.service(req, rep);
			rep.pushToClient(200);
			
			
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
	}
}
