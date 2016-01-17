package com.bjxst.net.tcp.chat.demo04;

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
 * ���������������ͬһ���߳���Ӧ�ö��������˴˶���
 * 	�����߳�
 * @author llf
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�������ǳ�:");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals(" ")||name.length()>20){
			System.out.println("���������������");
			name = br.readLine();
		}
		Socket client=  new Socket("localhost",8889);
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
