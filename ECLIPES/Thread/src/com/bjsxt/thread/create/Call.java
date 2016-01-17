package com.bjsxt.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 使用Callable调用线程
 * @author llf
 *
 */
public class Call {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程
		ExecutorService ser=Executors.newFixedThreadPool(2);
		Race tortoise =new Race("乌龟",1000);
		Race rabbit =new Race("兔子",500);
		//获取值
		Future<Integer>  result1=ser.submit(tortoise);
		Future<Integer>  result2=ser.submit(tortoise);
		Thread.sleep(50000);//2s
		rabbit.setFlag(false);//结束线程
		tortoise.setFlag(false);
		int num1= result1.get();
		int num2= result2.get();
		System.out.println("乌龟跑了"+num1+"步");
		System.out.println("兔子跑了"+num2+"步");
		//停止服务
		ser.shutdownNow();//结束线程
	}
}
class Race implements Callable<Integer>{
	private String name;//名称
	private long time;//延时时间
	private boolean flag=true;
	private int step=0;//步
	public Race() {
	}
	
	public Race(String name) {
		this.name =name;
	}
	
	public Race(String name,long time){
		this.name=name;
		this.time=time;
	}
	@Override
	public Integer call() throws Exception {
		while(flag){
			Thread.sleep(time);//延时
			step++;
		}
		
		return step;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	
}
