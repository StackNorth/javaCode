package com.bjsxt.thread.syn;
/**
 * 单例设计模式创建的方法
 * 懒汉式
 * 1、构造器私有化 避免外部直接创建对象
 * 2、声明一个私有的静态变量
 * 3、创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
 * 
 *
 */
public class MyJvm {
	private static MyJvm instance=null;
	 public MyJvm() {
	}
	 public static MyJvm getInstance(){
		 if(null==instance){//提高效率
			 synchronized(MyJvm.class){
				 if(null==instance){//安全
					 instance=new MyJvm();
				 }
			 }
			 
		 }
		 return instance;
		 
	 }
}
/**
 * 
* 饿汉式
 * 1、构造器私有化 
 * 2、声明一个私有的静态变量，同时创建该对象
 * 3、创建一个对外的公共的静态方法访问该变量
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
 * 类在使用时加载，使用内部类，延缓加载的时间
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
