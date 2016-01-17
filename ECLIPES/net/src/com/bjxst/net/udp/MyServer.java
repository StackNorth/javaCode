package com.bjxst.net.udp;

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
 * 5����������
 * 6���ͷ�
 * @author llf
 *
 */
public class MyServer {
	
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
		byte[] data= packer.getData();
		int len=packer.getLength();
		System.out.println(new String(data,0,len));
		//�ͷ�
		server.close();
	}
}
