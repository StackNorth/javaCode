package com.bjxst.net.URL;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * MalformedURLException畸形的异常
 * @author llf
 *
 */
public class URLDemo01 {
	public static void main(String[] args) throws MalformedURLException {
		//绝对路径构建
		URL url= new URL("http://www.baidu.com:80/index.html#aa?");
		//查看协议
		System.out.println("协议"+url.getProtocol());
		//主机名
		System.out.println("主机名"+url.getHost());
		//端口
		System.out.println("端口"+url.getPort());
		//资源
		System.out.println("资源"+url.getFile());
		//相对路径的资源
		System.out.println("相对路径的资源"+url.getPath());
		//锚点
		System.out.println("锚点"+url.getRef());
		System.out.println("参数"+url.getQuery());//？参数：？号后面为参数，如果有锚点返回null，不存在返回正确
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt");//相对路径
		System.out.println(url.toString());
	}
}
