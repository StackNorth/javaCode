package com.bjsxt.gui;

import java.awt.Color;
import java.awt.Frame;

public class MyFrame extends Frame{
	static int id=0;
	public MyFrame(int x,int y,int w,int h,Color color){
		super("my test" + (++id));
		setBackground(color);
		setVisible(true);
		setLayout(null);
		setBounds(x, y, w, h);
		
		
	}
}
