package com.bjsxt.thread.schedule;

import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Timer()
 * schedule(task, time);执行一次
 * schedule(task, firstTime, period)执行多次
 * @author llf
 *自学quartz网站
 */
public class TimerDemo01 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){//内部类 
			public void run() {
				System.out.println("so easy....");
			}
		},new Date(System.currentTimeMillis()+2000),1000);
		
	}
}
