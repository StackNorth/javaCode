package com.bjsxt.thread.pro;

public class viewer implements Runnable {
	private Movie m;
	
	public viewer(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			m.watch();
		}
	}
	
}
