package com.bjsxt.thread.syn;

/**
 * 线程安全，执行效率慢
 * @author llf
 *
 */
public class SynDemo01 {
	public static void main(String[] args) {
		Web12306 wb=new Web12306();
		Thread t1=new Thread(wb,"路人甲");
		Thread t2=new Thread(wb,"路人乙");
		Thread t3=new Thread(wb,"路人丙");
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
	 * 同步方法
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
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	/**
	 * 不加synchronized，线程不安全，不会return出去，
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
		System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
	}
	//线程不安全，锁定资源不正确
	public  void test04(){
		synchronized((Integer)num){//这里只锁住了num,对象里其他变量未锁定；一般锁定的为对象
			if(num<=0){
				flag=false;
				return;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
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
			System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
			}
	}
}
