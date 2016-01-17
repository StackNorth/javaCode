package com.bjxst.server.demo01;

import java.io.IOException;
import java.net.Socket;

import com.bjxst.net.tcp.chat.demo03.CloseUtil;

public class Dispatcher implements Runnable {
	private Socket client;
	private Request req;
	private Response rep;
	private int code=200;
	Dispatcher(Socket client){
		this.client=client;
		try {
			req= new Request(client.getInputStream());
			rep=new Response(client.getOutputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			code =500;
			return ;
		}
		
	}
	@Override
	public void run() {
		
		Servlet serv=new Servlet();
		serv.service(req, rep);
		try {
			rep.pushToClient(code);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		try {
			rep.pushToClient(500);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		CloseUtil.Close(client);
	}

}
