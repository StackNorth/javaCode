package com.bjsxt.thread.status;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 倒计时
 * 倒数十个数一秒内打印一个
 * @author llf
 *
 */
public class SleepDemo01 {
	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end=endTime.getTime();
		while(true){
			//输出
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			//构建下一秒的时间
			endTime= new Date(endTime.getTime()-1000);
			//等待下一秒
			Thread.sleep(1000);
			//10秒内继续，否则退出
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
