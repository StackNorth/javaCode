package com.bjsxt.thread.pro;

import com.bjsxt.thread.syn.synDemo02;

/**
 * һ������,��ͬ��Դ
 * ������������ģʽ �źŵƷ�
 * wait()��notify()/notifyAll--->Object��,�����ͬ��һ��ʹ�ã�û��ͬ��������ʹ��
 * wait()�ȴ� ���ͷ���  sleep()�����ͷ���
 * notify(()/notifyAll����
 * @author llf
 *
 */
public class Movie {
	private String pic;
	//�źŵ�
	//flag-->T�����������������ߵȴ���������ɺ�֪ͨ����
	//flag-->F���������ѣ������ߵȴ�����������ɺ�֪ͨ����������
	private boolean flag=true;
	
	/**
	 * ����
	 * @param args
	 * @throws InterruptedException 
	 */
	public synchronized void play(String pic){
		if(!flag){//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.pic=pic;
		System.out.println("������"+pic);
		//֪ͨ����
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
		//��ʼ����
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������"+pic);
		//֪ͨ����
		this.notify();
		//����ֹͣ
		this.flag=true;
	}
	
}
