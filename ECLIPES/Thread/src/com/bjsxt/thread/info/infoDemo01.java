package com.bjsxt.thread.info;
/**
 * Thread.currentThread()当前线程
 * SetName（）设置名称
 * GetName（）获取名称
 * isAlive（）判断状态
 * @author llf
 *
 */
public class infoDemo01 {

	public static void main(String[] args) throws InterruptedException {
		MyThread it=new MyThread();
		Thread proxy =new Thread(it,"it");
		proxy.setName("test");
		System.out.println(proxy.getName());
		System.out.println(proxy.currentThread().getName());
		proxy.start();
		System.out.println("启动后的状态："+proxy.isAlive());
		Thread.sleep(200);
		it.stop();
		Thread.sleep(100);
		System.out.println("停止后的状态："+proxy.isAlive());
	}

}
