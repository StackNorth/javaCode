package com.bjxst.net.tcp.chat.demo03;

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
		while(true){
			Socket client =server.accept();
			//д������
			//������
			DataInputStream dis=new DataInputStream(client.getInputStream());
			DataOutputStream dos= new DataOutputStream(client.getOutputStream());
			while(true){
				String msg=dis.readUTF();
				//System.out.println(msg);
				//�����
				dos.writeUTF("������-->"+msg);
				dos.flush();		
			}
		}	
	}
}