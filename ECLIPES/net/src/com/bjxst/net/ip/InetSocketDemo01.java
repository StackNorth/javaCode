package com.bjxst.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * �����˿ڣ���InetAddress������+�˿�
 * @author llf
 *
 */
public class InetSocketDemo01 {
	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("101.94.5.8",9999);//host��������
		System.out.println(address.getHostName());//��ȡ��������
		System.out.println(address.getPort());//��ȡ�˿�
		
		InetAddress addr= address.getAddress();
		System.out.println(addr.getHostAddress());//���ص�ַ
		System.out.println(addr.getHostName());//����������
		
		
	}
}
