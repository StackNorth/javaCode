package com.bjsxt.thread.status;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * ����ʱ
 * ����ʮ����һ���ڴ�ӡһ��
 * @author llf
 *
 */
public class SleepDemo01 {
	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end=endTime.getTime();
		while(true){
			//���
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//������һ���ʱ��
			endTime= new Date(endTime.getTime()-1000);
			//�ȴ���һ��
			Thread.sleep(1000);
			//10���ڼ����������˳�
			if(end-10000>endTime.getTime())break;
		}
	}
	public static void Daojishi() throws InterruptedException{
		int num=10;
		while(true){
			System.out.println(num--);
			Thread.sleep(1000);
			if(num<=0)break;
		}
		
	}
}