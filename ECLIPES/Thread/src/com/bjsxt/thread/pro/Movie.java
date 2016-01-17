package com.bjsxt.thread.pro;

import com.bjsxt.thread.syn.synDemo02;

/**
 * 一个场景,共同资源
 * 生产者消费者模式 信号灯法
 * wait()和notify()/notifyAll--->Object类,必须和同步一起使用，没有同步，不能使用
 * wait()等待 会释放锁  sleep()不会释放锁
 * notify(()/notifyAll唤醒
 * @author llf
 *
 */
public class Movie {
	private String pic;
	//信号灯
	//flag-->T生产者生产，消费者等待，生产完成后通知消费
	//flag-->F消费者消费，生产者等待，消费者完成后通知生产者生产
	private boolean flag=true;
	
	/**
	 * 播放
	 * @param args
	 * @throws InterruptedException 
	 */
	public synchronized void play(String pic){
		if(!flag){//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		//开始生产
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.pic=pic;
		System.out.println("生产了"+pic);
		//通知消费
		this.notify();
		this.flag=false;
	}
	
	public synchronized void watch() {
		if(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		//开始消费
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费了"+pic);
		//通知消费
		this.notify();
		//消费停止
		this.flag=true;
	}
	
}
