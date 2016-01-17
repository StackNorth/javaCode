package com.bjxst.net.tcp.chat.demo04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 创建客户端，发送数据+接收数据
 * 写出数据：输出流
 * 读取数据：输入流
 * 输入流与输出流在同一个线程内应该独立处理，彼此独立
 * 	加入线程
 * @author llf
 *
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("请输入昵称:");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals(" ")||name.length()>20){
			System.out.println("输入错误！重新输入");
			name = br.readLine();
		}
		Socket client=  new Socket("localhost",8889);
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
	}
}
