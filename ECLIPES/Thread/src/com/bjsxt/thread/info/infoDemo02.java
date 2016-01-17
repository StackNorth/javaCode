package com.bjsxt.thread.info;
/**
 * 优先级:概率，不代表的绝对的先后顺序
*static int MAX_PRIORITY 10
*线程可以具有的最高优先级。 
*static int MIN_PRIORITY 5默认为五
**线程可以具有的最低优先级。 
*static int NORM_PRIORITY 1
*分配给线程的默认优先级。 
setPriority()设置优先级
getPriority()
 * @author llf
 *
 */
public class infoDemo02 {
	public static void main(String[] args) throws InterruptedException {
		MyThread it=new MyThread();
		Thread p1 =new Thread(it,"it1");
		MyThread it2=new MyThread();
		Thread p2 =new Thread(it2,"it2");
		p1.setPriority(Thread.MIN_PRIORITY);//设置优先级
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		Thread.sleep(100);
		it.stop();
		it2.stop();
	}
}
