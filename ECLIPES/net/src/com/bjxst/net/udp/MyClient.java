package com.bjxst.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;
/**
 * 1�����������+�˿�
 * 2��׼������
 * 3����� �����͵ĵص㼰�˿ڣ�DatagramPacket(byte[],int length,InetSocketAddress Adderss)
 * 4������
 * 5���ͷ�
 * @author llf
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//���������+�˿�
		DatagramSocket client =new DatagramSocket(6666);
		//׼������
	//	String msg="���";
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		byte[] data=msg.getBytes();
		//��� �����͵ĵص㼰�˿ڣ�DatagramPacket(byte[],int length,InetSocketAddress Adderss)
		DatagramPacket packet=new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//����
		client.send(packet);
		//�ͷ�
		client.close();
	}
}
