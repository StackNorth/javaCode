package com.bjxst.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * 没有封装端口
 * @author llf
 *
 */
public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException {
		//使用 getLocalHost方法创建InetAddress对象
		InetAddress addr= InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//返回192.168.1.100
		System.out.println(addr.getHostName());//输出计算机名
		//根据域名得到InetAddress对象
		addr= InetAddress.getByName("www.163.com");
		System.out.println(addr.getHostAddress());//返回61.135.253.15
		System.out.println(addr.getHostName());//输出www.163.com
		//根据ip得到InetAddress对象
		addr=InetAddress.getByName("61.135.253.15");
		System.out.println(addr.getHostAddress());//返回163的服务器61.135.253.15
		System.out.println(addr.getHostName());//输出ip而不是域名，如果这个ip地址不存在返回自身
		
	}
}
