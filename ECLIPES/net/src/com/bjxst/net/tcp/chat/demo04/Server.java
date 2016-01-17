package com.bjxst.net.tcp.chat.demo04;

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
	private String name;
	private boolean isRunning=true;
public MyChannel(Socket client){
		try {
			dis=new DataInputStream(client.getInputStream());
			dos= new DataOutputStream(client.getOutputStream());
			this.name = dis.readUTF();
			this.send("欢迎进入聊天室");
			sendOthers(this.name+"进入聊天室",true);
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
	public void sendOthers(String msg,boolean sys){
		//遍历容器
		//私聊     以固定的格式来进行读取
		if(msg.startsWith("@")&& msg.indexOf(":")>-1){//startsWith测试是否从指定字符串开始indexOf返回指定字符在此字符串中第一次出现处的索引
			String name = msg.substring(1,msg.indexOf(":"));//返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1 处的字符
			String content =msg.substring(msg.indexOf(":")+1);//返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾
			for(MyChannel other:all){
				if(other.name.equals(name)){
					//私聊
					other.send(this.name+"对您悄悄说:"+content);
				}
			}
		}else{
			for(MyChannel other:all){
				if(other==this){
					continue;
				}
				if(sys){//sys为true时，为系统信息
					//系统信息
					other.send("系统信息"+msg);
				}else{
				//发送给其他客户端
				other.send(this.name+"对所有人说"+msg);
				}
			}
		}
	}
	
	public void run() {
		while(isRunning){
		sendOthers(receive(),false);
		}
	}
	
}
}
