package com.bjsxt.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class MyFrame03 extends Frame{
	public MyFrame03(String s,int x,int y,int w,int h, Color color) {
		super(s);
		Panel p= new Panel(null);
		setLayout(null);
		setBackground(color);
		setBounds(x, y, w, h);
		p.setBounds(w/4, h/4, w/2, h/2);
		p.setBackground(Color.YELLOW);
		setVisible(true); 
		add(p);
	}
}
