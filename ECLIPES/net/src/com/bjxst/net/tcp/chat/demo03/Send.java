package com.bjxst.net.tcp.chat.demo03;

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
	public Send() {
		console=new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
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
	public void send(){
		String info=getMsgFormConsle();
		try {
			if(null!=info&&!info.equals("")){
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
			send();
		}
		
	}

}
