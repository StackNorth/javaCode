package com.bjxst.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.rmi.server.ServerCloneException;

/**
 * 1�����������+�˿�
 * 2��׼����������
 * 3����װ�ɰ�
 * 4����������
 * 5����������    �ֽ�����---->double
 * 6���ͷ�
 * @author llf
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//���������+�˿�
		DatagramSocket server =new DatagramSocket(8888);
		//׼����������
		byte[] container =new byte[1024];
		//��װ�ɰ�
		DatagramPacket packer =new DatagramPacket(container,container.length);
		//��������
		server.receive(packer);
		//��������
		//byte[] data= packer.getData();
		//int len=packer.getLength();
		double data=convert(packer.getData());
		System.out.println(data);
		//�ͷ�
		server.close();
	}
	
	
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(data));
		double num=dis.readDouble();
		dis.close();
		return num;
	}
}
