package com.bjxst.net.tcp.chat.demo02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * 
 * @author llf
 *
 */
public class Server {
	private List<MyChannel> all= new ArrayList<MyChannel>();
	
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	public void start() throws IOException{
		ServerSocket server= new ServerSocket(6666);
		while(true){
			Socket client =server.accept();//返回套接字节点
			MyChannel channel =new MyChannel(client);
			all.add(channel);//统一管理
			new Thread(channel).start();//一条道路
		}
	
		
	}
/**
 * 一条客户端一条道路
 * 1、输入流
 *2、输出流
 *3、接收数据
 *4、发送数据 	
 * @author llf
 *
 */
	
	
private class MyChannel implements Runnable{
	private DataInputStream dis;
	private DataOutputStream dos;
	private boolean isRunning=true;
public MyChannel(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
			dos= new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			CloseUtil.Close(dis,dos);
			isRunning =false;
		}
	}
	/**
	 * 接收数据
	 * @return
	 */
	
	private String receive(){
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			CloseUtil.Close(dis,dos);
			isRunning =false;
			all.remove(this);

		}
		return msg;
	}
	/**
	 * 发送数据
	 * @param msg
	 */
	private void send(String msg){
		if(null==msg || msg.equals("")){
			return ;
		}
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			CloseUtil.Close(dis,dos);
			isRunning =false;
			all.remove(this);

		}
		
	}
	/**
	 * 发送给其他客户端
	 */
	public void sendOthers(){
		String msg=receive();
		//遍历容器
		for(MyChannel other:all){
			if(other==this){
				continue;
			}
			//发送给其他客户端
			other.send(msg);
		}
	}
	
	public void run() {
		while(isRunning){
		sendOthers();
		}
	}
	
}
}
