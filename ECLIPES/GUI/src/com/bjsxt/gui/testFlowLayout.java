package com.bjsxt.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class testFlowLayout {
	public static void main(String[] args) {
		Frame f= new Frame("FlowLayout");
		Button button1 = new Button("ok");
		Button button2 = new Button("open");
		Button button3 = new Button("close");
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.add(button1);
		f.add(button2);
		f.add(button3);
		f.setSize(100,100);
		f.setVisible(true);
	}
}
