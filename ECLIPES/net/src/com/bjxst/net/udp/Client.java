package com.bjxst.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
/**
 * 1、创建服务端+端口
 * 2、准备数据  double ----->字节数组 使用字节数组输出流
 * 3、打包 （发送的地点及端口）DatagramPacket(byte[],int length,InetSocketAddress Adderss)
 * 4、发送
 * 5、释放
 * @author llf
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		//创建服务端+端口
		DatagramSocket client =new DatagramSocket(6666);
		//准备数据
		//String msg="你好";
		double num=89.12;
		//byte[] data=msg.getBytes();
		byte[] data=convert(num);
		//打包 （发送的地点及端口）DatagramPacket(byte[],int length,InetSocketAddress Adderss)
		DatagramPacket packet=new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//发送
		client.send(packet);
		//释放
		client.close();
	}
	/**
	 * 字节数组  数据源+data输出流
	 * @param num
	 * @return
	 * @throws Exception 
	 */
	public static byte[] convert(double num) throws Exception{
		byte[] data=null;
		//接收转化后的字节数组
		ByteArrayOutputStream bos =new ByteArrayOutputStream();//为OutputStream的子类 ，有新增方法，不能发生多态
		//为数据写出创建对象
		DataOutputStream dos =new DataOutputStream(bos);//传进dataoutputstream()内的类为OutputStream的子类
		dos.writeDouble(num);//写入数据
		dos.flush();
		data= bos.toByteArray();//创建一个新分配的byte数组，其大小是输出流的当前大小，并将缓冲区的内容复制到该数组中
		dos.close();
		return data;
	}
}
