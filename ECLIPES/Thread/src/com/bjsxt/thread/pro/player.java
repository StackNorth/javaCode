package com.bjsxt.thread.pro;

public class player implements Runnable {
	private Movie m;
	public player(Movie m) {
		super();
		this.m=m;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			if(i%2==0){
				m.play("×óÇàÁú");
			}else{
				m.play("ÓÒ°×»¢");
			}
		}
	}

}
