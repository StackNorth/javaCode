package com.bjxst.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;
/**
 * 1、创建服务端+端口
 * 2、准备数据
 * 3、打包 （发送的地点及端口）DatagramPacket(byte[],int length,InetSocketAddress Adderss)
 * 4、发送
 * 5、释放
 * @author llf
 *
 */
public class MyClient {
	public static void main(String[] args) throws IOException {
		//创建服务端+端口
		DatagramSocket client =new DatagramSocket(6666);
		//准备数据
	//	String msg="你好";
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		byte[] data=msg.getBytes();
		//打包 （发送的地点及端口）DatagramPacket(byte[],int length,InetSocketAddress Adderss)
		DatagramPacket packet=new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//发送
		client.send(packet);
		//释放
		client.close();
	}
}
