package com.bjxst.net.tcp.chat.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * 
 * @author llf
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server= new ServerSocket(6666);
		Socket packet =server.accept();
		//输入流
		DataInputStream dis=new DataInputStream(packet.getInputStream());
		String msg=dis.readUTF();
		System.out.println("一个客户端已连接");
		//输出流
		DataOutputStream dos= new DataOutputStream(packet.getOutputStream());
		dos.writeUTF("服务器-->"+msg);
		dos.flush();		
		
			
	}
}
