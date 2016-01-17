package com.bjsxt.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class testGridLayout {
	public static void main(String[] args) {
		Frame f= new Frame("GridLayout Frame");
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		Button b4 = new Button("b4");
		Button b5 = new Button("b5");
		Button b6 = new Button("b6");
		Button b7 = new Button("b7");
		Button b8 = new Button("b8");
		f.setLayout(new GridLayout(2,3));
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		//f.pack();//自动设置Frame的大小，正好包裹住Button
		f.setVisible(true);
	}
}
