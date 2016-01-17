package com.bjsxt.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class PanelDemo01 {
	public static void main(String[] args) {
		Frame f =new Frame("My test Panel");
		f.setUndecorated(true);
		
		Panel p= new Panel();
		Panel p2 = new Panel();
		f.setLayout(null);
		//f.setBackground();
		f.setBounds(300, 300,200,400);
		p.setBounds(0, 30, 200, 200);
		p2.setBounds(0,200, 200, 200);
		f.setLayout(new FlowLayout());
		//p2.setLayout(new FlowLayout());
		p.setBackground( Color.GRAY);
		p2.setBackground( Color.GRAY);
		/*p.add(l);
		p.add(tf);
		p2.add(b1);
		p2.add(b2);*/
		f.add(p);
		f.add(p2);
		f.setVisible(true);
	}
}
