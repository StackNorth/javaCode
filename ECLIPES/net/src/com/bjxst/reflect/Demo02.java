package com.bjxst.reflect;

import com.bjxst.server.demo03.Servlet;

/**
 * ����ʵ�������ÿչ���
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clz=Class.forName("com.bjxst.server.demo03.LoginServlet");
		Servlet ser=(Servlet)clz.newInstance();
	}
}
