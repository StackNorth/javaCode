package com.bjsxt.thread.syn;
/**
 * 单例设计模式：外部使用时，确保一个类只有一个对象，外部只能使用对象，不能创建对象。
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
		System.out.println(Thread.currentThread().getName()+"创建-->"+Jvm.getInstance(time));
	}
	public JvmThread(long time){
		this.time=time;
		
	}
}

/*
 * 单例设计模式
 * 确保一个类只有一个对象
 * 懒汉式double checking（双重检查）
 * 1、构造器私有化 避免外部直接创建对象
 * 2、声明一个私有的静态变量
 * 3、创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
 * */
class Jvm{
	//声明一个私有的静态变量
	private static Jvm instance =null;
	//首先构造器私有化 避免外部直接创建对象
	private Jvm() {
	}
	
	public static Jvm getInstance(long time/*单例设计模式一般不会创建形参*/){
		//提高效率      与getInstance3的区别：getInstance3不管对象创建与否，都需进行判断，而此方法只对未创建对象进行创建，以创建了的直接返回
		if(null==instance){
			synchronized(Jvm.class){//获取Jvm对象
				if(null==instance){
					try {
						Thread.sleep(time);//延时，放大放生错误的概率
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Jvm();
				}
			}
		}
		return instance;
	}

	
	public static Jvm getInstance3(long time/*单例设计模式一般不会创建形参*/){
		//效率不高
		synchronized(Jvm.class){//获取Jvm对象
			if(null==instance){
				try {
					Thread.sleep(time);//延时，放大放生错误的概率
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new Jvm();
			}
		}
		return instance;
	}
	
	public static synchronized Jvm getInstance2(long time/*单例设计模式一般不会创建形参*/){
		if(null==instance){
			try {
				Thread.sleep(time);//延时，放大放生错误的概率
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
	}
	//创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	public static Jvm getInstance1(long time/*单例设计模式一般不会创建形参*/){
		if(null==instance){
			try {
				Thread.sleep(time);//延时，放大放生错误的概率
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Jvm();
		}
		return instance;
		
	}
	
}