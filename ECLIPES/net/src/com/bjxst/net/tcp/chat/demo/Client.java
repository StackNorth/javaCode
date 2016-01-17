package com.bjxst.net.tcp.chat.demo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * �����ͻ��ˣ���������+��������
 * д�����ݣ������
 * ��ȡ���ݣ�������
 * ���������������ͬһ���߳���Ӧ�ö����������˴˶���
 * 	�����߳�
 * @author llf
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=  new Socket("localhost",6666);
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos= new DataOutputStream(client.getOutputStream());
		DataInputStream dis=new DataInputStream(client.getInputStream());
		while(true){
			String info =console.readLine();
			//�����
			dos.writeUTF(info);
			dos.flush();
			//������
			String msg=dis.readUTF();
			System.out.println(msg);
		}
	}
}