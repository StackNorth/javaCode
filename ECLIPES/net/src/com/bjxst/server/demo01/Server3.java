package com.bjxst.server.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ������������������
 * ������Ӧ
 *
 */
public class Server3 {
	private ServerSocket server;
	private static final String CRLF="\r\n";
	private String BLANK=" ";
	public static void main(String[] args){
		Server3 server =new Server3();
		server.start();
		
	}
	/**
	 * ����������
	 */
	public void start(){
		 try {
			server =new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ������������
	 */
	private void receive(){
		try {
			Socket client=server.accept();
			StringBuilder sb =new StringBuilder();
			byte[] data=new byte[20480];
			int len=client.getInputStream().read(data); //��ȡ����ֵ������������data��
			//���տͻ���������Ϣ
			String requestInfo =new String(data,0,len).trim();
			System.out.println(requestInfo);
			
			//��Ӧ
			StringBuilder responseContent =new StringBuilder();
			//������Ϣ
			responseContent.append("<html><head><title>HTTP��Ӧ����</title>"+
			"</head><body>������ѧ�û�ӭ��!</body></html>");
			StringBuilder response=new StringBuilder();
			//HTTPЭ��汾��״̬���롢����
			response.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(BLANK);
			//��Ӧͷ��response head��
			response.append("Server:bjxst Server/0.0.1").append(CRLF);
			response.append("Date:").append(new Date()).append(CRLF);
			response.append("Content-type:text/html;charset=GBK;").append(CRLF);
			//���ĳ��ȣ��ֽڳ���
			response.append("Content-Length:").append(responseContent.toString().getBytes().length).append(CRLF);
			//����֮ǰ
			response.append(CRLF);
			//����
			response.append(responseContent);
			
			
			//�����
			BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			bw.write(response.toString());
			bw.flush();
			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void stop(){
	}
}
