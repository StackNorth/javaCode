package com.bjxst.net.tcp.socket;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  ������
 *  ������������������������
 *  1������������ ָ���˿�serverSocket��int prot��;
 *  2�����տͻ�������  ����ʽ
 *  ��������+��������
 * @author llf
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//���������� ָ���˿�serverSocket��int prot��;
		ServerSocket server =new ServerSocket(8888);//�������˿ڱ����ֶ�����
		//���տͻ�������  ����ʽ
		Socket packet=server.accept();
		System.out.println("һ���ͻ��˽�������");
		String msg="��ӭʹ��";
		/*BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter
				(packet.getOutputStream()));
		bw.write(msg);
		bw.newLine();
		bw.flush();
		*/
		DataOutputStream dos =new DataOutputStream(packet.getOutputStream());
		dos.writeUTF(msg);
	}

}
