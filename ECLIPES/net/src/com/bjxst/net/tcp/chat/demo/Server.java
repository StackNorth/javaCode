package com.bjxst.net.tcp.chat.demo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����������
 * 
 * @author llf
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server= new ServerSocket(6666);
		Socket packet =server.accept();
		//������
		DataInputStream dis=new DataInputStream(packet.getInputStream());
		String msg=dis.readUTF();
		System.out.println("һ���ͻ���������");
		//�����
		DataOutputStream dos= new DataOutputStream(packet.getOutputStream());
		dos.writeUTF("������-->"+msg);
		dos.flush();		
		
			
	}
}
