package com.bjsxt.thread.syn;
/**
 * �������ģʽ���ⲿʹ��ʱ��ȷ��һ����ֻ��һ�������ⲿֻ��ʹ�ö��󣬲��ܴ�������
 * @author llf
 *
 */
public class synDemo02 {
	public static void main(String[] args) {
		JvmThread thread1 = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);
		thread1.start();
		thread2.start();
	}
}

class JvmThread extends Thread{
	private long time;
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"����-->"+Jvm.getInstance(time));
	}
	public JvmThread(long time){
		this.time=time;
		
	}
}

/*
 * �������ģʽ
 * ȷ��һ����ֻ��һ������
 * ����ʽdouble checking��˫�ؼ�飩
 * 1��������˽�л� �����ⲿֱ�Ӵ�������
 * 2������һ��˽�еľ�̬����
 * 3������һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
 * */
class Jvm{
	//����һ��˽�еľ�̬����
	private static Jvm instance =null;
	//���ȹ�����˽�л� �����ⲿֱ�Ӵ�������
	private Jvm() {
	}
	
	public static Jvm getInstance(long time/*�������ģʽһ�㲻�ᴴ���β�*/){
		//���Ч��      ��getInstance3������getInstance3���ܶ��󴴽���񣬶�������жϣ����˷���ֻ��δ����������д������Դ����˵�ֱ�ӷ���
		if(null==instance){
			synchronized(Jvm.class){//��ȡJvm����
				if(null==instance){
					try {
						Thread.sleep(time);//��ʱ���Ŵ��������ĸ���
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}
			}
		}
		return instance;
	}

	
	public static Jvm getInstance3(long time/*�������ģʽһ�㲻�ᴴ���β�*/){
		//Ч�ʲ���
		synchronized(Jvm.class){//��ȡJvm����
			if(null==instance){
				try {
					Thread.sleep(time);//��ʱ���Ŵ��������ĸ���
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
		}
		return instance;
	}
	
	public static synchronized Jvm getInstance2(long time/*�������ģʽһ�㲻�ᴴ���β�*/){
		if(null==instance){
			try {
				Thread.sleep(time);//��ʱ���Ŵ��������ĸ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
	//����һ������Ĺ����ľ�̬�������ʸñ������������û�ж��󣬴����ö���
	public static Jvm getInstance1(long time/*�������ģʽһ�㲻�ᴴ���β�*/){
		if(null==instance){
			try {
				Thread.sleep(time);//��ʱ���Ŵ��������ĸ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
		
	}
	
}