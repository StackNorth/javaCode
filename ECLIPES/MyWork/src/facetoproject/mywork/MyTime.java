package facetoproject.mywork;

public class MyTime {
	private int hour;
	private int minute;
	private int second;
	public MyTime(int x,int y,int z){
	this.hour = x;
	this.minute = y;
	this.second = z;
	}
	
	
	public void diaplay(){
		System.out.println("this time is:" + this.hour + this.minute + this.second);
	}
	
	public void addSecond(int sec){
		this.second += sec;
	}
	
	public void addMinute(int min){
		this.minute += min;
	}
	
	public void addHour(int hou){
		this.hour += hou;
	}
	public void subSecond(int sec){
		this.second -= sec;
	}
	
	public void subMinute(int min){
		this.minute -= min;
	}
	
	public void subHour(int hou){
		this.hour -= hou;
	}
}
