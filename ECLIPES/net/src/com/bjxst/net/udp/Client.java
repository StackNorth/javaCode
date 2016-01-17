package com.bjxst.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
/**
 * 1�����������+�˿�
 * 2��׼������  double ----->�ֽ����� ʹ���ֽ����������
 * 3����� �����͵ĵص㼰�˿ڣ�DatagramPacket(byte[],int length,InetSocketAddress Adderss)
 * 4������
 * 5���ͷ�
 * @author llf
 *
 */
public class Client {
	public static void main(String[] args) throws Exception {
		//���������+�˿�
		DatagramSocket client =new DatagramSocket(6666);
		//׼������
		//String msg="���";
		double num=89.12;
		//byte[] data=msg.getBytes();
		byte[] data=convert(num);
		//��� �����͵ĵص㼰�˿ڣ�DatagramPacket(byte[],int length,InetSocketAddress Adderss)
		DatagramPacket packet=new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//����
		client.send(packet);
		//�ͷ�
		client.close();
	}
	/**
	 * �ֽ�����  ����Դ+data�����
	 * @param num
	 * @return
	 * @throws Exception 
	 */
	public static byte[] convert(double num) throws Exception{
		byte[] data=null;
		//����ת������ֽ�����
		ByteArrayOutputStream bos =new ByteArrayOutputStream();//ΪOutputStream������ �����������������ܷ�����̬
		//Ϊ����д����������
		DataOutputStream dos =new DataOutputStream(bos);//����dataoutputstream()�ڵ���ΪOutputStream������
		dos.writeDouble(num);//д������
		dos.flush();
		data= bos.toByteArray();//����һ���·����byte���飬���С��������ĵ�ǰ��С�����������������ݸ��Ƶ���������
		dos.close();
		return data;
	}
}
