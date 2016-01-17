package com.bjxst.reflect;
/**
 * 获取结构信息class对象（源头）
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String str="abc";
		//class对象
		//对象.getclass（）
		Class<?> clz=str.getClass();
		//类.class
		clz =String.class;
		//最常用  完整路径
		clz=Class.forName("java.lang.String");
	}
}
