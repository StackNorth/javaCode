package com.bjsxt.thread.schedule;

import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Timer()
 * schedule(task, time);ִ��һ��
 * schedule(task, firstTime, period)ִ�ж��
 * @author llf
 *��ѧquartz��վ
 */
public class TimerDemo01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){//�ڲ��� 
			public void run() {
				System.out.println("so easy....");
			}
		},new Date(System.currentTimeMillis()+2000),1000);
		
	}
}
