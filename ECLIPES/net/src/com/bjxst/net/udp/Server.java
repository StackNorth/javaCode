package com.bjxst.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.rmi.server.ServerCloneException;

/**
 * 1、创建服务端+端口
 * 2、准备接收容器
 * 3、封装成包
 * 4、接收数据
 * 5、分析数据    字节数组---->double
 * 6、释放
 * @author llf
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//创建服务端+端口
		DatagramSocket server =new DatagramSocket(8888);
		//准备接收容器
		byte[] container =new byte[1024];
		//封装成包
		DatagramPacket packer =new DatagramPacket(container,container.length);
		//接收数据
		server.receive(packer);
		//分析数据
		//byte[] data= packer.getData();
		//int len=packer.getLength();
		double data=convert(packer.getData());
		System.out.println(data);
		//释放
		server.close();
	}
	
	
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(data));
		double num=dis.readDouble();
		dis.close();
		return num;
	}
}
