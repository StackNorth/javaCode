package com.bjsxt.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class testBorderLayout {
	public static void main(String[] args) {
		Frame f= new Frame("Border layout");
		Button bn = new Button("bn");
		Button bw = new Button("bw");
		Button be = new Button("be");
		Button bc = new Button("bc");
		Button bs = new Button("bs");

		f.add(bn,BorderLayout.NORTH);
		f.add(bw,BorderLayout.WEST);
		f.add(be,BorderLayout.EAST);
		f.add(bc,BorderLayout.CENTER);
		f.add(bs,BorderLayout.SOUTH);
		
		f.setSize(200, 200);//设置Frame的大小
		f.setVisible(true);//设置可见性
	}
}
