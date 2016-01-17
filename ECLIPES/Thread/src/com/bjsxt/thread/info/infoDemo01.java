package com.bjsxt.thread.info;
/**
 * Thread.currentThread()��ǰ�߳�
 * SetName������������
 * GetName������ȡ����
 * isAlive�����ж�״̬
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
		System.out.println("�������״̬��"+proxy.isAlive());
		Thread.sleep(200);
		it.stop();
		Thread.sleep(100);
		System.out.println("ֹͣ���״̬��"+proxy.isAlive());
	}

}
