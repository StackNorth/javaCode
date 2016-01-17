package com.bjxst.net.tcp.socket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  服务器
 *  必须先启动服务器，后连接
 *  1、创建服务器 指定端口serverSocket（int prot）;
 *  2、接收客户端连接  阻塞式
 *  发送数据+接收数据
 * @author llf
 *
 */
public class MultiServer {
	public static void main(String[] args) throws IOException {
		//创建服务器 指定端口serverSocket（int prot）;
		ServerSocket server =new ServerSocket(8888);//服务器端口必须手动分配
		//接收客户端连接  阻塞式
		while(true){
			Socket packet=server.accept();//
			System.out.println("一个客户端建立连接");
			String msg="欢迎使用";
			DataOutputStream dos =new DataOutputStream(packet.getOutputStream());
			dos.writeUTF(msg);
		}
	}
}
