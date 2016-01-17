package com.bjxst.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * û�з�װ�˿�
 * @author llf
 *
 */
public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ�� getLocalHost��������InetAddress����
		InetAddress addr= InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//����192.168.1.100
		System.out.println(addr.getHostName());//����������
		//���������õ�InetAddress����
		addr= InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//����61.135.253.15
		System.out.println(addr.getHostName());//���www.163.com
		//����ip�õ�InetAddress����
		addr=InetAddress.getByName("61.135.253.15");
		System.out.println(addr.getHostAddress());//����163�ķ�����61.135.253.15
		System.out.println(addr.getHostName());//���ip������������������ip��ַ�����ڷ�������
		
	}
}
