package com.bjsxt.thread.info;
/**
 * ���ȼ�:���ʣ�������ľ��Ե��Ⱥ�˳��
*static int MAX_PRIORITY 10
*�߳̿��Ծ��е�������ȼ��� 
*static int MIN_PRIORITY 5Ĭ��Ϊ��
**�߳̿��Ծ��е�������ȼ��� 
*static int NORM_PRIORITY 1
*������̵߳�Ĭ�����ȼ��� 
setPriority()�������ȼ�
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
		p1.setPriority(Thread.MIN_PRIORITY);//�������ȼ�
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		Thread.sleep(100);
		it.stop();
		it2.stop();
	}
}
