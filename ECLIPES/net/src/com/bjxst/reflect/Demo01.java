package com.bjxst.reflect;
/**
 * ��ȡ�ṹ��Ϣclass����Դͷ��
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException {
		String str="abc";
		//class����
		//����.getclass����
		Class<?> clz=str.getClass();
		//��.class
		clz =String.class;
		//���  ����·��
		clz=Class.forName("java.lang.String");
	}
}
