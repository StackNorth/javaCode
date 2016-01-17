package com.bjsxt.thread.syn;

/**
 * �̰߳�ȫ��ִ��Ч����
 * @author llf
 *
 */
public class SynDemo01 {
	public static void main(String[] args) {
		Web12306 wb=new Web12306();
		Thread t1=new Thread(wb,"·�˼�");
		Thread t2=new Thread(wb,"·����");
		Thread t3=new Thread(wb,"·�˱�");
		t1.start();
		t2.start();
		t3.start();		
	}
}

class Web12306 implements Runnable{
	private int num=10;
	private boolean flag=true;
	@Override
	public void run() {
		while(flag){
			test03();
		}
	}
	/**
	 * ͬ������
	 */
	public synchronized void test01(){
		if(num<=0){
			flag=false;
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
	/**
	 * ����synchronized���̲߳���ȫ������return��ȥ��
	 */
	
	public  void test02(){
		if(num<=0){
			flag=false;
			return;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"������"+num--);
	}
	//�̲߳���ȫ��������Դ����ȷ
	public  void test04(){
		synchronized((Integer)num){//����ֻ��ס��num,��������������δ������һ��������Ϊ����
			if(num<=0){
				flag=false;
				return;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������"+num--);
			}
	}
	public  void test03(){
		synchronized(this){
			if(num<=0){
				flag=false;
				return;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"������"+num--);
			}
	}
}
