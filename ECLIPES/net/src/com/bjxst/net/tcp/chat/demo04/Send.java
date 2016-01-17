package com.bjxst.net.tcp.chat.demo04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ��������
 * @author llf
 *
 */
public class Send implements Runnable {
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//�����߳�
	private boolean isRunning=true;
	//��ʼ������
	private String name;
	//��ʼ������
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client,String name){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
			send(this.name);
		} catch (IOException e) {
			isRunning =false;
			CloseUtil.Close(dos,console);
		}
		
	}
	//�ӿ���̨��������
	public String getMsgFormConsle(){
		
		try {
			return console.readLine();
		} catch (IOException e) {
			
		}
		return "";
	}
	//��������
	public void send(String info){
		try {
			if(null!=info&&!info.equals(" ")){
				dos.writeUTF(info);
				dos.flush();//ǿ��ˢ��
			}
		} catch (IOException e) {
			isRunning=false;
			CloseUtil.Close(dos,console);
		}
		
	}
	public void run() {
		while(isRunning){
			//�߳���
			send(getMsgFormConsle());
		}
		
	}

}
