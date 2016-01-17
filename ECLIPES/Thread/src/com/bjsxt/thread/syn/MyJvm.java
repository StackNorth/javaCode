package com.bjsxt.thread.syn;
/**
 * �������ģʽ�����ķ���
 * ����ʽ
 * 1��������˽�л� �����ⲿֱ�Ӵ�������
 * 2������һ��˽�еľ�̬����
 * 3������һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
 * 
 *
 */
public class MyJvm {
	private static MyJvm instance=null;
	 public MyJvm() {
	}
	 public static MyJvm getInstance(){
		 if(null==instance){//���Ч��
			 synchronized(MyJvm.class){
				 if(null==instance){//��ȫ
					 instance=new MyJvm();
				 }
			 }
			 
		 }
		 return instance;
		 
	 }
}
/**
 * 
* ����ʽ
 * 1��������˽�л� 
 * 2������һ��˽�еľ�̬������ͬʱ�����ö���
 * 3������һ������Ĺ����ľ�̬�������ʸñ���
 */
class MyJvm2 {
	private static MyJvm2 instance=new MyJvm2();
	 public MyJvm2() {
	}
	 public static MyJvm2 getInstance(){
		 return instance;
		 
	 }
}

/**
 * ����ʹ��ʱ���أ�ʹ���ڲ��࣬�ӻ����ص�ʱ��
 * @author llf
 *
 */
class MyJvm3 {
	public static class JVMholder{
	private static MyJvm3 instance=new MyJvm3();
	}
	 public MyJvm3() {
	}
	 public static MyJvm3 getInstance(){
		 return JVMholder.instance;
		 
	 }
}
