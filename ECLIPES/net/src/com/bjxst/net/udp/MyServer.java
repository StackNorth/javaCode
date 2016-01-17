package com.bjxst.net.udp;

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
 * 5、分析数据
 * 6、释放
 * @author llf
 *
 */
public class MyServer {
	
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
		byte[] data= packer.getData();
		int len=packer.getLength();
		System.out.println(new String(data,0,len));
		//释放
		server.close();
	}
}
