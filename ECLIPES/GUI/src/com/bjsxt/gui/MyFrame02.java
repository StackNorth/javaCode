package com.bjsxt.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class MyFrame02 extends Frame{
	private Panel p1,p2,p3,p4;
	public MyFrame02(String s,int x,int y,int w,int h) {
		super(s);
		p1 = new Panel(null);
		p2 = new Panel(null);
	    p3 = new Panel(null);
		p4 = new Panel(null);
		p1.setBounds(0, 0, w/2, h/2);
		p2.setBounds(0, h/2, w/2, h/2);
		p3.setBounds(w/2, 0, w/2, h/2);
		p4.setBounds(w/2, h/2, w/2, h/2);
		p1.setBackground(Color.BLUE);
		p2.setBackground(Color.CYAN);
		p3.setBackground(Color.DARK_GRAY);
		p4.setBackground(Color.GRAY);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		setVisible(true);
		setBounds(x, y, w, h);
	}
}
