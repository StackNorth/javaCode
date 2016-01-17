package com.bjxst.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 包含端口：在InetAddress基础上+端口
 * @author llf
 *
 */
public class InetSocketDemo01 {
	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("101.94.5.8",9999);//host（主机）
		System.out.println(address.getHostName());//获取主机名称
		System.out.println(address.getPort());//获取端口
		
		InetAddress addr= address.getAddress();
		System.out.println(addr.getHostAddress());//返回地址
		System.out.println(addr.getHostName());//输出计算机名
		
		
	}
}
